package com.yubotao.test.copy.util;

import com.yubotao.test.copy.CopyTest;
import com.yubotao.test.copy.domain.UserDO;
import com.yubotao.test.copy.domain.UserVO;

/**
 * @author: yubt
 * @description:
 * @date: Created in 14:21 2021/05/19
 * @modified By:
 */
public class CloneUtil extends CopyTest implements CopyUtil{

    public static void main(String[] args) {
        totalTest(new CloneUtil());
    }


    @Override
    public UserDO copyDO(UserDO userDO) {
        return userDO.clone();
    }

    @Override
    public UserVO copyVO(UserDO userDO) {
        return null;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
