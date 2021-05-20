package com.yubotao.test.copy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: yubt
 * @description:
 * @date: Created in 11:49 2021/05/19
 * @modified By:
 */
@Getter
@Setter
public class UserDO extends Person implements Serializable, Cloneable {

    private Long id;

    private String name;

    private Date birthday;

    private Integer cardNo;

    private Integer age;

    private Address address;

    public UserDO clone(){
        UserDO newDO = new UserDO();
        try {
            newDO = (UserDO) super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        // 无它浅拷贝
        newDO.address = address.clone();
        return newDO;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", cardNo=" + cardNo +
                ", age=" + age +
                ", address=" + address +
                ", realName='" + realName + '\'' +
                '}';
    }
}
