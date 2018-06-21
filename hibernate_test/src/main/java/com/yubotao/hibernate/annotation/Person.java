package com.yubotao.hibernate.annotation;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:03 2018/6/21
 * @Modified By:
 */
@Entity
@Table(name = "t_person", catalog = "hibernatetest")
public class Person {

    @Id
    @GenericGenerator(name = "myuuid", strategy = "uuid") // 声明一种主键生成策略(uuid)
    @GeneratedValue(generator = "myuuid") // 引用uuid主键生成策略
    private String id;

    @Type(type = "string") // 允许你去指定Hibernate里面的一些类型
    private String name;

    @Transient // 现在这个属性不想生成在表中
    private String msg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
