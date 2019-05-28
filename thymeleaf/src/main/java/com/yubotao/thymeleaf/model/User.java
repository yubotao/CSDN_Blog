package com.yubotao.thymeleaf.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:39 2018/9/7
 * @Modified By:
 */
@ToString
public class User {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String telephone;
    @Getter
    @Setter
    private Date registerTime;
    @Getter
    @Setter
    private int popedom;  // 权限 0-管理员 1-普通用户
}
