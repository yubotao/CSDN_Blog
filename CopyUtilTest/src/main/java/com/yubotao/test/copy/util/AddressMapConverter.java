package com.yubotao.test.copy.util;

import com.yubotao.test.copy.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author: yubt
 * @description:
 * @date: Created in 18:00 2021/05/20
 * @modified By:
 */
@Mapper
public interface AddressMapConverter {

    AddressMapConverter INSTANCE = Mappers.getMapper(AddressMapConverter.class);

    Address getAddr(Address userDO);

}
