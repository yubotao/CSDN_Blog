package com.yubotao.test.copy.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yubotao.test.copy.CopyTest;
import com.yubotao.test.copy.domain.UserDO;
import com.yubotao.test.copy.domain.UserVO;

/**
 * @author: yubt
 * @description:
 * @date: Created in 14:23 2021/05/19
 * @modified By:
 */
public class Fastjson extends CopyTest implements CopyUtil{

    public static void main(String[] args) {
        totalTest(new Fastjson());
    }


    @Override
    public UserDO copyDO(UserDO userDO) {
        return JSON.parseObject(JSON.toJSONString(userDO), UserDO.class);
    }

    @Override
    public UserVO copyVO(UserDO userDO) {
        return JSON.parseObject(JSON.toJSONString(userDO), UserVO.class);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}