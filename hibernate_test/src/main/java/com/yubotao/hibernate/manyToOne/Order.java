package com.yubotao.hibernate.manyToOne;

import javax.persistence.*;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:14 2018/6/21
 * @Modified By:
 */
@Entity
@Table(name = "c_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double money;
    private String receiverInfo; // 收货地址

    // 订单与客户关联
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "c_customer_id") // 指定外键列
    private Customer c; // 描述订单属于某一个客户


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getReceiverInfo() {
        return receiverInfo;
    }

    public void setReceiverInfo(String receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", money=" + money +
                ", receiverInfo='" + receiverInfo + '\'' +
                '}';
    }
}
