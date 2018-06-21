package com.yubotao.hibernate.manyToMany;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:29 2018/6/21
 * @Modified By:
 */
@Entity
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(targetEntity = Teacher.class)
    // @JoinTable：使用@JoinTable来描述中间表，并描述中间表中外键与Student、Teacher的映射关系
    // joinColumns：它是用来描述Student与中间表的映射关系
    // inverseJoinColumns：它是用来描述Teacher与中间表的映射关系
    @JoinTable(name = "s_t", joinColumns = {@JoinColumn(name = "c_student_id",referencedColumnName = "id")},inverseJoinColumns = {@JoinColumn(name = "c_teacher_id")})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<Teacher> teachers = new HashSet<Teacher>();

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

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
