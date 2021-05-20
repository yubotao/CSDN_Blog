package com.yubotao.test.copy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: yubt
 * @description:
 * @date: Created in 11:49 2021/05/19
 * @modified By:
 */
@Getter
@Setter
public class UserVO extends Person implements Serializable {

    private Long userId;

    private String name;

    private String birthday;

    private String cardNo;

    private int age;

    private Address address;

    @Override
    public String toString() {
        return "UserVO{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", realName='" + realName + '\'' +
                '}';
    }
}
