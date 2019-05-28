package com.yubotao.thymeleaf.controller;

import com.yubotao.thymeleaf.model.User;
import com.yubotao.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:52 2018/9/7
 * @Modified By:
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/showOneUser")
    public String showOneUser(Model model){
        User user = userService.findOneUser();
        model.addAttribute("user",user);

        return "showOneUser";
    }

    @RequestMapping("/showAllUsers")
    public String showAllUsers(Model model){
        List<User> userList = userService.findAllUsers();
        model.addAttribute("users", userList);

        return "showAllUsers ";
    }

}
