package com.yubotao.test.copy.util;

import com.yubotao.test.copy.CopyTest;
import com.yubotao.test.copy.DateUtil;
import com.yubotao.test.copy.domain.UserDO;
import com.yubotao.test.copy.domain.UserVO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

/**
 * @author: yubt
 * @description:
 * @date: Created in 14:22 2021/05/19
 * @modified By:
 */
public class ModelMapperUtil extends CopyTest implements CopyUtil{

    private ModelMapper modelMapper = new ModelMapper();

    public static void main(String[] args) {
        totalTest(new ModelMapperUtil());
    }


    @Override
    public UserDO copyDO(UserDO userDO) {
        return modelMapper.map(userDO, UserDO.class);
    }

    @Override
    public UserVO copyVO(UserDO userDO) {
        modelMapper.addMappings(customField());
        return modelMapper.map(userDO, UserVO.class);
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    private static PropertyMap customField(){
        /**
         * 自定义映射规则
         */
        return  new PropertyMap<UserDO, UserVO>() {
            @Override
            protected void configure() {
                /**使用自定义转换规则*/
                map(source.getId(), destination.getUserId());
                map(source.getBirthday(), source.getBirthday());
            }
        };
    }

}
