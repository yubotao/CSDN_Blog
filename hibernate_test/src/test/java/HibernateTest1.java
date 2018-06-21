import com.yubotao.hibernate.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 11:27 2018/6/21
 * @Modified By:
 */
public class HibernateTest1 {

    @Test
    public void saveCustomerTest(){
        Customer customer = new Customer();
        customer.setName("jesus");
        customer.setAddress("heaven");
        customer.setSex("male");

        // 使用Hibernate的API来完成将Customer信息保存到mysql数据库中的操作
        Configuration config = new Configuration().configure();// Hibernate框架加载hibernate.cfg.xml文件
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();// 相当于得到一个Connection
        // 开启事务
        session.beginTransaction();

        session.save(customer);

        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void findCustomerByIdTest(){
        Configuration config = new Configuration().configure();// Hibernate框架加载hibernate.cfg.xml文件
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();// 相当于得到一个Connection
        // 开启事务
        session.beginTransaction();

        Customer c = session.load(Customer.class,2);

        System.out.println(c);

        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void updateCustomerTest(){
        Configuration config = new Configuration().configure();// Hibernate框架加载hibernate.cfg.xml文件
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();// 相当于得到一个Connection
        // 开启事务
        session.beginTransaction();

        Customer c = session.get(Customer.class, 55);
        c.setName("Jehovah");
        session.update(c);// 修改操作

        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void deleteCustomerTest(){
        Configuration config = new Configuration().configure();// Hibernate框架加载hibernate.cfg.xml文件
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();// 相当于得到一个Connection
        // 开启事务
        session.beginTransaction();

        Customer c = session.get(Customer.class,1);
        session.delete(c);

        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void findAllCustomerTest(){
        Configuration config = new Configuration().configure();// Hibernate框架加载hibernate.cfg.xml文件
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();// 相当于得到一个Connection
        // 开启事务
        session.beginTransaction();

        Query query = session.createQuery("from Customer");// HQL语句，它类似于SQL语句
        List<Customer> list = query.list();
        System.out.println(list);

        // 事务提交
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
