package com.yubotao.test.copy.util;

import com.yubotao.test.copy.CopyTest;
import com.yubotao.test.copy.domain.UserDO;
import com.yubotao.test.copy.domain.UserVO;
import org.apache.commons.beanutils.BeanUtils;

/**
 * @author: yubt
 * @description:
 * @date: Created in 14:19 2021/05/19
 * @modified By:
 */
public class ApacheBeanUtils extends CopyTest implements CopyUtil{

    public static void main(String[] args) {
        totalTest(new ApacheBeanUtils());
    }

    @Override
    public UserDO copyDO(UserDO userDO) {
        UserDO newDO = new UserDO();
        try {
            BeanUtils.copyProperties(newDO, userDO);
        }catch (Exception e){
            e.printStackTrace();
        }
        return newDO;
    }

    @Override
    public UserVO copyVO(UserDO userDO) {
        UserVO userVO = new UserVO();
        try {
            BeanUtils.copyProperties(userVO, userDO);
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
