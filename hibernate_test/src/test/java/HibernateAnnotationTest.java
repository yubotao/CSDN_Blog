import com.yubotao.hibernate.annotation.Book;
import com.yubotao.hibernate.annotation.Person;
import com.yubotao.hibernate.manyToMany.Student;
import com.yubotao.hibernate.manyToMany.Teacher;
import com.yubotao.hibernate.manyToOne.Customer;
import com.yubotao.hibernate.manyToOne.Order;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Date;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:01 2018/6/21
 * @Modified By:
 */
public class HibernateAnnotationTest {
    // 测试PO的注解开发
    @Test
    public void test1() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        Book b = new Book();
        b.setName("情书");
        b.setPrice(56.78);
        b.setPublicationDate(new Date());

        session.save(b);

        session.getTransaction().commit();
        session.close();
    }

    // 测试uuid的主键生成策略及不生成表中映射
    @Test
    public void test2() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        Person p = new Person();
        p.setName("李四");
        p.setMsg("这是一个好人");

        session.save(p);

        session.getTransaction().commit();
        session.close();
    }

    // 测试one-to-many注解操作(保存客户时级联保存订单)
    @Test
    public void test3() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 1.创建一个客户
        Customer c = new Customer();
        c.setName("叶子");

        // 2.创建两个订单
        Order o1 = new Order();
        o1.setMoney(1000d);
        o1.setReceiverInfo("武汉");
        Order o2 = new Order();
        o2.setMoney(2000d);
        o2.setReceiverInfo("天门");

//        // 3.建立关系
//        c.getOrders().add(o1);
//        c.getOrders().add(o2);

        // 3.建立关系
        // 原因：是为了维护外键，不然的话，外键就不能正确的生成！！！
        o1.setC(c);
        o2.setC(c);

        // 原因：是为了进行级联操作
        c.getOrders().add(o1);
        c.getOrders().add(o2);

        // 4.保存客户，并级联保存订单
        session.save(c);

        session.getTransaction().commit();
        session.close();
    }

    // 测试多对多级联保存(保存学生时同时保存老师)
    @Test
    public void test4() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 1.创建两个老师
        Teacher t1 = new Teacher();
        t1.setName("Tom");

        Teacher t2 = new Teacher();
        t2.setName("Fox");

        // 2.创建两个学生
        Student s1 = new Student();
        s1.setName("张丹");

        Student s2 = new Student();
        s2.setName("叶紫");

        // 3.学生关联老师
        s1.getTeachers().add(t1);
        s1.getTeachers().add(t2);

        s2.getTeachers().add(t1);
        s2.getTeachers().add(t2);

        // 保存学生同时保存老师
        session.save(s1);
        session.save(s2);

        session.getTransaction().commit();
        session.close();
    }

    // 测试多对多级联删除(前提是建立了双向的级联)
    // *******测试失败*******
    @Test
    public void test5() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        Student s = session.get(Student.class, 3);
        session.delete(s);

        session.getTransaction().commit();
        session.close();
    }
}
