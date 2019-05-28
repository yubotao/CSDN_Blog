package com.yubotao.springOAuth2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:02 2018/7/26
 * @Modified By:
 */
@RestController
public class TestEndpointsController {

    @Autowired
    RestTemplate restTemplate;

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

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Principal user(Principal user){
        return user;
    }

}
