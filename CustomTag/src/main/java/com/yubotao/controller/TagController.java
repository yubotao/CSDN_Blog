package com.yubotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yubotao on 2017/12/06.
 */
@Controller
public class TagController {
    
    @RequestMapping(value = "/tags",method = RequestMethod.GET)
    public String getTags(Model model){
        Long date = System.currentTimeMillis();
        model.addAttribute("date",date);
        return "tags";
    }
    
}
