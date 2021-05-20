package com.yubotao.test.copy.util;

import com.yubotao.test.copy.CopyTest;
import com.yubotao.test.copy.domain.UserDO;
import com.yubotao.test.copy.domain.UserVO;
import org.springframework.beans.BeanUtils;

/**
 * @author: yubt
 * @description:
 * @date: Created in 14:19 2021/05/19
 * @modified By:
 */
public class SpringBeanUtils extends CopyTest implements CopyUtil{

    public static void main(String[] args) {
        totalTest(new SpringBeanUtils());
    }


    @Override
    public UserDO copyDO(UserDO userDO) {
        UserDO newDO = new UserDO();
        BeanUtils.copyProperties(userDO, newDO);
        return newDO;
    }

    @Override
    public UserVO copyVO(UserDO userDO) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userDO, userVO);
        return userVO;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
