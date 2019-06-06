package com.yubotao.autoSerial.model;

import javax.persistence.*;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 11:46 2019/5/29
 * @Modified By:
 */
@Entity
@Table(name = "auto_serial")
public class AutoSerial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "serial")
    private String serial;

    @Column(name = "strategy")
    private String strategy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }
}
