package com.common.user.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Author：xiongzhan
 * Description：获取Session内容
 * Date: 2018-07-28 23:07
 */
public class SessionUtil {

    public static String getCurrUid() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomizeUserDetails userDetails = (CustomizeUserDetails) authentication.getPrincipal();
        if (userDetails != null) {
            return userDetails.getLenderId();
        }

        return null;

    }

    public static void clear() {

        SecurityContextHolder.clearContext();
    }
}
