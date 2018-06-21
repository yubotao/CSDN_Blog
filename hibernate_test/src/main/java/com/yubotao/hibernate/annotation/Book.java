package com.yubotao.hibernate.annotation;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:51 2018/6/21
 * @Modified By:
 */
@Entity // 定义了一个实体
@Table(name = "t_book",catalog = "hibernatetest")
public class Book {

    @Id // 这表示一个主键
    // @GeneratedValue 相当于native主键生成策略
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 相当于identity主键生成策略
    private Integer id; // 主键

    @Column(name = "b_name",length = 30, nullable = true)
    private String name;

    @Temporal(TemporalType.TIMESTAMP) // 是用来定义日期类型
    private Date publicationDate; // 出版日期

    @Type(type = "double") // 允许你去指定Hibernate里面的一些类型
    private Double price; // 价格，如果没有添加注解，也会自动的生成在表中

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

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publicationDate=" + publicationDate +
                ", price=" + price +
                '}';
    }
}
