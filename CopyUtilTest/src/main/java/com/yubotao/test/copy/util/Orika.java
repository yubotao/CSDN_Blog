package com.yubotao.test.copy.util;

import com.yubotao.test.copy.CopyTest;
import com.yubotao.test.copy.DateUtil;
import com.yubotao.test.copy.domain.UserDO;
import com.yubotao.test.copy.domain.UserVO;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: yubt
 * @description: 在激烈的角逐及厮杀中，凭借其中庸的表现胜出
 * @date: Created in 14:22 2021/05/19
 * @modified By:
 */
public class Orika extends CopyTest implements CopyUtil{

    private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    private static MapperFacade mapper;

    {
        mapperFactory.getConverterFactory().registerConverter(new DateConverter());
        mapperFactory.classMap(UserDO.class, UserVO.class).field("id", "userId").byDefault().register();
        mapper = mapperFactory.getMapperFacade();
    }

    public static void main(String[] args) {
        totalTest(new Orika());
        List<UserDO> doList = getDOList();
        printListStr(doList);
        List<UserVO> voList = copyList(doList);
        printListStr(voList);
    }

    private static List<UserVO> copyList(List<UserDO> doList){
        return mapper.mapAsList(doList, UserVO.class);
    }

    private static <T> void printListStr(List<T> list){
        if (list == null){
            System.out.println("数组为null");
        }
        System.out.println("List结果如下：");
        list.forEach(c -> System.out.println(c));
    }

    private static List<UserDO> getDOList(){
        ArrayList<UserDO> result = new ArrayList<>();
        result.add(getDO());
        UserDO userDO = getDO();
        userDO.setName("盖亚!");
        result.add(userDO);

        return result;
    }

    @Override
    public UserDO copyDO(UserDO userDO) {
        return mapper.map(userDO, UserDO.class);
    }

    @Override
    public UserVO copyVO(UserDO userDO) {
        return mapper.map(userDO, UserVO.class);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    private class DateConverter extends BidirectionalConverter<Date, String> {
        @Override
        public String convertTo(Date source, Type<String> destinationType, MappingContext context) {
            return DateUtil.format(source);
        }
        @Override
        public Date convertFrom(String source, Type<Date> destinationType, MappingContext context) {
            Date result = null;
            try {
                result = DateUtil.parse(source);
            }catch (ParseException e){
                e.printStackTrace();
            }
            return result;
        }
    }
}