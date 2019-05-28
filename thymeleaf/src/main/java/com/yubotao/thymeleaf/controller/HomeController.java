package com.yubotao.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 9:55 2018/9/7
 * @Modified By:
 */
@Controller
public class HomeController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/showStudent")
    public String showStudent(){
        return "showStudent";
    }

    @RequestMapping("test")
    public String test(Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response){
        WebContext ctx = new WebContext(request, response, request.getServletContext());
        ctx.setVariable("book", "《智能时代》");
        session.setAttribute("city", "醉美泸州");

        return "testThymeleafObjects";
    }

}
