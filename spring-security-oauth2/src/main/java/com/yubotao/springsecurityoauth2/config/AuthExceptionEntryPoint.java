package com.yubotao.springsecurityoauth2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 11:36 2018/10/11
 * @Modified By:
 */
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Value("${server.url}")
    private  String serverUrl;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException)
            throws ServletException {

//        Map map = new HashMap();
//        map.put("error", "401");
//        map.put("message", "token过期，请重新登陆");
//        map.put("path", request.getServletPath());
//        map.put("timestamp", String.valueOf(new Date().getTime()));
//        response.setContentType("application/json");
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        try {
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.writeValue(response.getOutputStream(), map);
            System.out.println("进入Entry方法");
            response.sendRedirect(serverUrl + "/error/401");
        } catch (Exception e) {
            throw new ServletException();
        }
    }

}
