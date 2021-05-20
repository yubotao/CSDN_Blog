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
public class SerializationUtils extends CopyTest implements CopyUtil{

    public static void main(String[] args) {
        totalTest(new SerializationUtils());
    }

    @Override
    public UserDO copyDO(UserDO userDO) {
        return org.apache.commons.lang3.SerializationUtils.clone(userDO);
    }

    @Override
    public UserVO copyVO(UserDO userDO) {
        return org.apache.commons.lang3.SerializationUtils.deserialize(org.apache.commons.lang3.SerializationUtils.serialize(userDO));
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
