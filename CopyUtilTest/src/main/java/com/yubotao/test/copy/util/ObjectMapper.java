package com.yubotao.test.copy.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.yubotao.test.copy.CopyTest;
import com.yubotao.test.copy.domain.UserDO;
import com.yubotao.test.copy.domain.UserVO;

/**
 * @author: yubt
 * @description:
 * @date: Created in 14:23 2021/05/19
 * @modified By:
 */
public class ObjectMapper extends CopyTest implements CopyUtil{

    private static com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
    {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static void main(String[] args) {
        totalTest(new ObjectMapper());
    }


    @Override
    public UserDO copyDO(UserDO userDO) {
        UserDO newDO = new UserDO();
        try {
            newDO = mapper.readValue(mapper.writeValueAsString(userDO), UserDO.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return newDO;
    }

    @Override
    public UserVO copyVO(UserDO userDO) {
        UserVO userVO = new UserVO();
        try {
            userVO = mapper.readValue(mapper.writeValueAsString(userDO), UserVO.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return userVO;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
