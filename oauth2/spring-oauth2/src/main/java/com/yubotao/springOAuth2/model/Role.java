package com.yubotao.springOAuth2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:44 2018/12/17
 * @Modified By:
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "name")
    private String name;
}
