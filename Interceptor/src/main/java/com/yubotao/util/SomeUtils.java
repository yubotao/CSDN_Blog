package com.yubotao.util;

import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 20:10 2018/2/27
 * @Modified By:
 */
@Service
public class SomeUtils {

    public void setCookies(HttpServletResponse response, User user) throws ServletException,IOException{
        System.out.println("Enter setCookie()");
        try{
            String username = user.getName();
            String password = user.getPassword();
            String token = username + "," + password;
            Cookie cookie = new Cookie("user", token);
            cookie.setMaxAge(60 * 2);
            cookie.setPath("/");
            response.addCookie(cookie);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean checkCookie(HttpServletRequest request) throws ServletException,IOException{
        System.out.println("Enter checkCookie()");
        boolean flag = false;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (int i=0; i<cookies.length; i++){
                if(cookies[i].getName().equals("user")){
                    try{
                        String token = cookies[i].getValue();
                        String[] elements = token.split(",");
                        String username = elements[0];
                        String password = elements[1];
                        if(username.equals("admin") && password.equals("key")){
                            flag = true;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return flag;
    }

}
