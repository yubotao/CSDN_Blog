package com.yubotao.springOAuth2.controller;


import com.alibaba.fastjson.JSONObject;
import com.yubotao.springOAuth2.jpa.AccountJpa;
import com.yubotao.springOAuth2.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

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

    @Autowired
    AccountJpa accountJpa;

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
    public Map user(Principal principal){
        LinkedHashMap result = new LinkedHashMap();
        JSONObject principalJson =(JSONObject) JSONObject.toJSON(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Account account = accountJpa.findAccountByUsername(principalJson.getString("username"));
        if (account == null){
            result.put("code", 500);
            result.put("message", "user is null");
        }else {
            result.put("id", account.getId());
            result.put("username", account.getUsername());
        }

        return result;
    }

}
