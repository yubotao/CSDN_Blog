package com.yubotao.controller;

import com.yubotao.uitl.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 17:09 2018/2/27
 * @Modified By:
 */
@Controller
public class CookieController {

    private static final Log log = LogFactory.getLog(CookieController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        String username = request.getParameter("user");
        String password = request.getParameter("password");

        if(username != "" && password != ""){
            Cookie cookie = new Cookie("user",username + "," + password);
            cookie.setMaxAge(60);
            cookie.setPath("/");
            response.addCookie(cookie);
            response.sendRedirect("/check");
        }else {
            response.sendRedirect("/fail");
        }
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public void check(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        Cookie[] cookies = request.getCookies();
        for(int i=0; i<cookies.length; i ++){
            if(cookies[i].getName().equals("user")){
                String value = cookies[i].getValue();
                String[] elements = value.split(",");
                String username = elements[0];
                String password = elements[1];
                if(username.equals("admin")&&password.equals("key")){
                    response.sendRedirect("/success");
                }else {
                    response.sendRedirect("/fail");
                }
            }
        }
    }

    @RequestMapping(value = "/fail", method = RequestMethod.GET)
    public String fail(){
        return "fail";
    }

    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(){
        return "success";
    }
}
