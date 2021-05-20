package com.yubotao.test.copy.util;

import com.yubotao.test.copy.CopyTest;
import com.yubotao.test.copy.DateUtil;
import com.yubotao.test.copy.domain.UserDO;
import com.yubotao.test.copy.domain.UserVO;
import org.springframework.cglib.core.Converter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author: yubt
 * @description:
 * @date: Created in 14:21 2021/05/19
 * @modified By:
 */
public class BeanCopier extends CopyTest implements CopyUtil{

    private static org.springframework.cglib.beans.BeanCopier doCopier = org.springframework.cglib.beans.BeanCopier.create(UserDO.class, UserDO.class, false);
    private static org.springframework.cglib.beans.BeanCopier voCopier = org.springframework.cglib.beans.BeanCopier.create(UserDO.class, UserVO.class, true);

    public static void main(String[] args) {
        totalTest(new BeanCopier());
    }


    @Override
    public UserDO copyDO(UserDO userDO) {
        UserDO newDO = new UserDO();
        doCopier.copy(userDO, newDO, null);
        return newDO;
    }

    @Override
    public UserVO copyVO(UserDO userDO) {
        UserVO userVO = new UserVO();
        voCopier.copy(userDO, userVO, new UserConverter());
        return userVO;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    public class UserConverter implements Converter {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        @Override
        public Object convert(Object value, Class target, Object context) {
            if (value instanceof Integer) {
                return value;
            } else if (value instanceof Date){
                return DateUtil.format((Date) value);
            } else if (value instanceof LocalDateTime) {
                LocalDateTime date = (LocalDateTime) value;
                return dtf.format(date);
            } else if (value instanceof BigDecimal) {
                BigDecimal bd = (BigDecimal) value;
                return bd.toPlainString();
            }
            // 更多类型转换请自定义
            return value;
        }
    }
}
