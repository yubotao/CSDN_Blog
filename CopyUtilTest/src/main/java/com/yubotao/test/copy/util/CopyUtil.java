package com.yubotao.test.copy.util;

import com.yubotao.test.copy.domain.UserDO;
import com.yubotao.test.copy.domain.UserVO;

/**
 * @author: yubt
 * @description:
 * @date: Created in 11:59 2021/05/19
 * @modified By:
 */
public interface CopyUtil {

    UserDO copyDO(UserDO userDO);

    UserVO copyVO(UserDO userDO);

    String getName();

}
