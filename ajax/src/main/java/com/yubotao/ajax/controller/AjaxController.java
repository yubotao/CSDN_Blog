package com.yubotao.ajax.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:55 2018/9/13
 * @Modified By:
 */
@Controller
public class AjaxController {

    @RequestMapping(value = "/getPage", method = RequestMethod.GET)
    public String getPage(Model model){
        return "input";
    }

    @RequestMapping(value = "/input", method = RequestMethod.POST)
    @ResponseBody
    public String input(@Param("name") String name, @Param("sex") String sex, @Param("age") String age){
        System.out.println("姓名： " + name);
        System.out.println("性别： " + sex);
        System.out.println("年龄： " + age);

        JSONObject json = new JSONObject();
        json.fluentPut("code", 200);
        return json.toString();
    }

}
