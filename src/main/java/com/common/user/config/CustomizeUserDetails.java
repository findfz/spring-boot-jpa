package com.common.user.config;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Author：xiongzhan
 * Description：自定义UserDetails
 * Date: 2018-07-28 23:07
 */
@Data
public class CustomizeUserDetails extends User {

    private String lenderId;

    private String productCode;

    public CustomizeUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String lenderId, String productCode) {
        super(username, password, authorities);
        this.setLenderId(lenderId);
        this.setProductCode(productCode);
    }
}
