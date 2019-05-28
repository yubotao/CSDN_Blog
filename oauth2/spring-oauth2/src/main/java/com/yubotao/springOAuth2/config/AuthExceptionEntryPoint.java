package com.yubotao.springOAuth2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 11:36 2018/10/11
 * @Modified By:
 */
@Component
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Value("${server.url}")
    private  String serverUrl;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException)
            throws ServletException {

        try {
            System.out.println("进入Entry方法");
            response.sendRedirect(serverUrl + "/error/401");
        } catch (Exception e) {
            throw new ServletException();
        }
    }

}
