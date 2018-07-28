package com.common.user.config;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Author：xiongzhan
 * Description：
 * Date: 2018-07-28 16:15
 */
public class JWTAuthentication extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 865507321522897337L;

    private UserDetails principal;

    private String jsonWebToken;

    public JWTAuthentication(UserDetails principal, String jsonWebToken) {
        super(principal.getAuthorities());
        this.principal = principal;
        this.jsonWebToken = jsonWebToken;
    }


    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}
