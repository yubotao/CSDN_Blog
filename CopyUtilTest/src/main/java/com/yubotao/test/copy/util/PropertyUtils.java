package com.yubotao.test.copy.util;

import com.yubotao.test.copy.CopyTest;
import com.yubotao.test.copy.domain.UserDO;
import com.yubotao.test.copy.domain.UserVO;

/**
 * @author: yubt
 * @description:
 * @date: Created in 14:19 2021/05/19
 * @modified By:
 */
public class PropertyUtils extends CopyTest implements CopyUtil{

    public static void main(String[] args) {
        totalTest(new PropertyUtils());
    }


    @Override
    public UserDO copyDO(UserDO userDO) {
        UserDO newDO = new UserDO();
        try {
            org.apache.commons.beanutils.PropertyUtils.copyProperties(newDO, userDO);
        }catch (Exception e){
            e.printStackTrace();
        }
        return newDO;
    }

    @Override
    public UserVO copyVO(UserDO userDO) {
        UserVO userVO = new UserVO();
        try {
            org.apache.commons.beanutils.PropertyUtils.copyProperties(userVO, userDO);
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
