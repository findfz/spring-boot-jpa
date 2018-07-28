package com.common.user.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author：xiongzhan
 * Description：JWT授权provider
 * Date: 2018-07-28 16:04
 */
@Component
public class JsonWebTokenAuthenticationProvider implements AuthenticationProvider {


    private JsonWebTokenUtility tokenService = new JsonWebTokenUtility();


    @Override
    public Authentication authenticate(Authentication authentication)

            throws AuthenticationException {

        Authentication authenticatedUser = null;

        // Only process the PreAuthenticatedAuthenticationToken

        if (authentication.getClass().

                isAssignableFrom(PreAuthenticatedAuthenticationToken.class)

                && authentication.getPrincipal() != null) {

            String tokenHeader = (String) authentication.getPrincipal();

            UserDetails userDetails = parseToken(tokenHeader);

            if (userDetails != null) {

                authenticatedUser =

                        new JWTAuthentication(userDetails, tokenHeader);

            }

        } else {

            // It is already a JsonWebTokenAuthentication

            authenticatedUser = authentication;

        }

        return authenticatedUser;

    }



    private UserDetails parseToken(String tokenHeader) {


        UserDetails principal = null;

        AuthTokenDetailsDTO authTokenDetails =

                tokenService.parseAndValidate(tokenHeader);



        if (authTokenDetails != null) {

            List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");

            principal = new CustomizeUserDetails(authTokenDetails.getName(), "123456", authorityList, authTokenDetails.getLenderId(),authTokenDetails.getProductCode());

        }



        return principal;

    }



    @Override

    public boolean supports(Class<?> authentication) {

        return

                authentication.isAssignableFrom(

                        PreAuthenticatedAuthenticationToken.class)||

                        authentication.isAssignableFrom(

                                JWTAuthentication.class);

    }
}
