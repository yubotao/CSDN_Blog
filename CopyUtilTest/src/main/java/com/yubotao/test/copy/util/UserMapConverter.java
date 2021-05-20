package com.yubotao.test.copy.util;

import com.yubotao.test.copy.domain.UserDO;
import com.yubotao.test.copy.domain.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author: yubt
 * @description:
 * @date: Created in 16:20 2021/05/19
 * @modified By:
 */
@Mapper
public interface UserMapConverter {

    UserMapConverter INSTANCE = Mappers.getMapper(UserMapConverter.class);

    UserDO getDO(UserDO userDO);

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "birthday", source = "birthday", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserVO do2vo(UserDO userDO);

}
