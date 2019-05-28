package com.yubotao.springOAuth2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:45 2018/12/17
 * @Modified By:
 */
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "username")
    private String username;
    @Getter
    @Setter
    @Column(name = "password")
    private String password;
    @Getter
    @Setter
    @OneToMany(mappedBy = "account")
    private List<AccountRole> accountRoles;
}
