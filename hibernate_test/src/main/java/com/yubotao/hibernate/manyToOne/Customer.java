package com.yubotao.hibernate.manyToOne;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:09 2018/6/21
 * @Modified By:
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    // 描述客户可以有多个订单
    /*
     * targetEntity="..."：相当于<one-to-many class="...">
     * mappedBy="..."：相当于inverse=true，即放弃关联关系的维护，不然会生成一个中间表
     */
    @OneToMany(targetEntity = Order.class, mappedBy = "c")
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<Order> orders = new HashSet<Order>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orders=" + orders +
                '}';
    }
}
