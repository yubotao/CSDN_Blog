package com.yubotao.controller;

import com.yubotao.util.SomeUtils;
import com.yubotao.util.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 20:30 2018/2/27
 * @Modified By:
 */
@Controller
public class InterceptorController {

    private static final Log log = LogFactory.getLog(InterceptorController.class);

    @Autowired
    private SomeUtils utils;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException{
        System.out.println(user);
        if(user.getName().equals("admin") && user.getPassword().equals("key")){
            System.out.println("Enter login()");
            utils.setCookies(response, user);
            return "redirect:/a/Pass";
        }
        return "redirect:/fail";
    }

    @RequestMapping(value = "/a/Pass", method = RequestMethod.GET)
    public String pass(){
        return "pass";
    }

    @RequestMapping(value = "/fail", method = RequestMethod.GET)
    public String fail(){
        return "fail";
    }

}
