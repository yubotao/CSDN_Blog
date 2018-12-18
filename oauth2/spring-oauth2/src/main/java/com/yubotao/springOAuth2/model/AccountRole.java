package com.yubotao.springOAuth2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:45 2018/12/17
 * @Modified By:
 */
@Entity
@Table(name = "account_role")
public class AccountRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;
    @Getter
    @Setter
    @JoinColumn(name = "role_id")
    @ManyToOne
    private Role role;
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
