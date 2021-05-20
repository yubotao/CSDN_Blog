package com.yubotao.test.copy.util;

import com.yubotao.test.copy.CopyTest;
import com.yubotao.test.copy.DateUtil;
import com.yubotao.test.copy.domain.Address;
import com.yubotao.test.copy.domain.UserDO;
import com.yubotao.test.copy.domain.UserVO;

/**
 * @author: yubt
 * @description:
 * @date: Created in 14:16 2021/05/19
 * @modified By:
 */
public class GetSet extends CopyTest implements CopyUtil {

    public static void main(String[] args) {
        totalTest(new GetSet());
    }

    @Override
    public UserDO copyDO(UserDO userDO) {
        UserDO newDO = new UserDO();
        newDO.setId(userDO.getId());
        newDO.setName(userDO.getName());
        newDO.setRealName(userDO.getRealName());
        newDO.setAge(userDO.getAge());
        newDO.setBirthday(userDO.getBirthday());
        newDO.setCardNo(userDO.getCardNo());
        Address newAddr = new Address();
        newAddr.setAddress(userDO.getAddress().getAddress());
        newDO.setAddress(newAddr);
        return newDO;
    }

    @Override
    public UserVO copyVO(UserDO userDO) {
        UserVO newVO = new UserVO();
        newVO.setUserId(userDO.getId());
        newVO.setName(userDO.getName());
        newVO.setRealName(userDO.getRealName());
        newVO.setAge(userDO.getAge());
        newVO.setBirthday(DateUtil.format(userDO.getBirthday()));
        newVO.setCardNo(userDO.getCardNo().toString());
        Address newAddr = new Address();
        newAddr.setAddress(userDO.getAddress().getAddress());
        newVO.setAddress(newAddr);
        return newVO;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
