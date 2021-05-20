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
@ToString
public class Address implements Serializable, Cloneable {

    private String address;

    public Address clone(){
        Address address = new Address();
        try {
            address = (Address) super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return address;
    }

}
