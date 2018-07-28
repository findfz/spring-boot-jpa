/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package com.common.user.config;

import com.alibaba.fastjson.JSON;
import com.common.util.RestResp;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author：xiongzhan
 * Description：无权限时返回
 * Date: 2018-07-28 15:19
 */
public class NoAuthenticationEntryPoint implements AuthenticationEntryPoint {

    //当访问的资源没有权限，会调用这里
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {


        //返回json形式的错误信息
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        RestResp restResp = RestResp.error(1101,"没有权限");

        response.getWriter().println(JSON.toJSONString(restResp));
        response.getWriter().flush();
    }
}