package com.yubotao.springsecurityoauth2.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:02 2018/7/26
 * @Modified By:
 */
@RestController
public class TestEndpointsController {

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id){
        // for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product id: " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id){
        // for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "order id: " + id;
    }

}
