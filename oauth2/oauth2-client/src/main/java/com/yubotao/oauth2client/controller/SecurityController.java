package com.yubotao.oauth2client.controller;

import com.alibaba.fastjson.JSONObject;
import com.yubotao.oauth2client.util.AuthenticationUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 11:26 2018/12/18
 * @Modified By:
 */
@RestController
public class SecurityController {
    @RequestMapping(value = "/testOAuth2", method = RequestMethod.GET)
    public String testOAuth2(){
        return "oauth2 protects me";
    }

    @RequestMapping(value = "/getUserInfoByAuthUtil")
    public JSONObject getUserInfoByAuthUtil(){
        return AuthenticationUtil.getUserInfo();
    }
}
