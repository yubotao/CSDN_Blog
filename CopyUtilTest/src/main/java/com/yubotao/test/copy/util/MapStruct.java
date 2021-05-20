package com.yubotao.test.copy.util;

import com.yubotao.test.copy.CopyTest;
import com.yubotao.test.copy.domain.UserDO;
import com.yubotao.test.copy.domain.UserVO;

/**
 * @author: yubt
 * @description:
 * @date: Created in 14:22 2021/05/19
 * @modified By:
 */
public class MapStruct extends CopyTest implements CopyUtil{

    public static void main(String[] args) {
        totalTest(new MapStruct());
    }

    @Override
    public UserDO copyDO(UserDO userDO) {
        UserDO newDO = UserMapConverter.INSTANCE.getDO(userDO);
        newDO.setAddress(AddressMapConverter.INSTANCE.getAddr(userDO.getAddress()));
        return newDO;
    }

    @Override
    public UserVO copyVO(UserDO userDO) {
        UserVO userVO = UserMapConverter.INSTANCE.do2vo(userDO);
        userVO.setAddress(AddressMapConverter.INSTANCE.getAddr(userDO.getAddress()));
        return userVO;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
