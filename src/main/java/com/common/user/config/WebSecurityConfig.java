/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.common.user.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Author：xiongzhan
 * Description：请求拦截配置
 * Date: 2018-07-28 23:07
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends JWTSecurityConfig {
    @Override
    protected void setupAuthorization(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                // allow anonymous access to /customer/login endpoint
                .antMatchers("/user/createJwt").permitAll()
                // authenticate all other requests
                .anyRequest().authenticated();
    }


}