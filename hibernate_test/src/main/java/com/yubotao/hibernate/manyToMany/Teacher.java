package com.yubotao.hibernate.manyToMany;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:34 2018/6/21
 * @Modified By:
 */
@Entity
@Table(name = "t_teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(targetEntity = Student.class, mappedBy = "teachers") // 代表由对方来维护外键
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<Student> students = new HashSet<Student>();

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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
