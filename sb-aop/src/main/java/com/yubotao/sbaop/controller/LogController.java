package com.yubotao.sbaop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:47 2018/11/23
 * @Modified By:
 */
@RestController
public class LogController {

    @RequestMapping("/first")
    public Object first(){
        System.out.println("进入first() 方法");
        return "first Controller";
    }

    @RequestMapping("/doError")
    public Object error(){
        return 1/0;
    }

}
