package com.yubotao.springsecurityoauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 17:17 2018/10/10
 * @Modified By:
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping(value = "/401", method = RequestMethod.GET)
    public String error_401(){
        return "error_401";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String error_404(){
        return "error_404";
    }

    @RequestMapping(value = "/500", method = RequestMethod.GET)
    public String error_500(){
        return "error_500";
    }

}
