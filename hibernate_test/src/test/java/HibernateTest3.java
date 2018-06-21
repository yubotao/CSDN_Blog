import com.yubotao.hibernate.Customer;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 11:50 2018/6/21
 * @Modified By:
 */
public class HibernateTest3 {

    // 向表中插入100条记录
    @Test
    public void test2() {
        Session session = HibernateUtils.openSession();
        // 不要忘记开事务
        session.beginTransaction();

        for (int i = 0; i < 100; i++) {
            Customer c = new Customer();
            c.setName("姓名" + i);
            c.setSex("男");
            c.setAddress("北京");
            session.save(c);
        }

        session.getTransaction().commit();
        session.close();
    }

    // 分页查询
    // 一页显示10条，要得到第二页数据
    @Test
    public void test3() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 一页显示10条，要得到第二页数据
        Query query = session.createQuery("from Customer");
        query.setFirstResult(10); // 从第几条开始，即开始位置，从0开始计数
        query.setMaxResults(10); // 本次查询结果回显的条数
        List<Customer> list = query.list();
        System.out.println(list);

        session.getTransaction().commit();
        session.close();
    }

    // 条件查询，可以使用where关键字
    @Test
    public void test5() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 查询name=姓名0的信息
        Query query = session.createQuery("from Customer where name=?"); // 这是一种无名称参数
        // 要对参数进行赋值
        query.setParameter(0, "姓名0");

        List<Customer> list = query.list();
        System.out.println(list);

        session.getTransaction().commit();
        session.close();
    }

    // 条件查询，可以使用where关键字
    @Test
    public void test6() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 查询name=姓名0的信息
        Query query = session.createQuery("from Customer where name=:myname"); // 这是一种有名称参数
        // 对有名称参数进行赋值
        query.setParameter("myname", "姓名0");

        // 如果能保证结果就是唯一的，那么可以使用另外一种方法
        Customer customer = (Customer) query.uniqueResult();
        System.out.println(customer);

        session.getTransaction().commit();
        session.close();
    }

    // 执行本地sql，条件查询
    @Test
    public void test7() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 执行 select * from t_customer where name=?;
        SQLQuery sqlQuery = session.createSQLQuery("select * from t_customer where name=?");
        // 对参数进行赋值
        sqlQuery.setParameter(0, "姓名1");

        // 想要将结果封装到Customer对象中
        sqlQuery.addEntity(Customer.class);
        /*
        List<Customer> list = sqlQuery.list();
        System.out.println(list);
        */
        Customer customer = (Customer) sqlQuery.uniqueResult();
        System.out.println(customer);

        session.getTransaction().commit();
        session.close();
    }

}
