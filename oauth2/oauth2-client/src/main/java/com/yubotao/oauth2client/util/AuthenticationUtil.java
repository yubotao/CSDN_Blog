package com.yubotao.oauth2client.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 11:19 2019/5/28
 * @Modified By:
 */
public class AuthenticationUtil {

    public static JSONObject getUserInfo(){
        JSONObject authentication =(JSONObject) JSONObject.toJSON(SecurityContextHolder.getContext().getAuthentication());
        // 返回的信息为user-info端点对应接口的返回值
        return (JSONObject) ((JSONObject) authentication.get("userAuthentication")).get("details");
    }

    public static String getUserId(){
        JSONObject userInfo = getUserInfo();
        return (String)userInfo.get("id");
    }
}
