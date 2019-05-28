import com.yubotao.hibernate.manyToOne.Customer;
import com.yubotao.hibernate.manyToOne.Order;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:08 2018/6/21
 * @Modified By:
 */
public class HQLTest {

    // 准备数据(2个Customer，每一个Customer有10个Order)
    @Test
    public void test1() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();


        // 操作
        Customer c = new Customer();
        c.setName("武松");
        // 需要先将主表数据插入表中，否则从表无法插入，会报错save the transient instance before flushing
        session.persist(c);

        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setMoney(1000d + i * 10);
            order.setReceiverInfo("北京");
            order.setC(c);
            session.save(order);
        }


        Customer c2 = new Customer();
        c2.setName("潘金莲");
        session.persist(c2);

        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setMoney(2000d + i * 10);
            order.setReceiverInfo("上海");
            order.setC(c2);
            session.save(order);
        }

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void test2(){
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 1.编写HQL语句
        String hql = "from Customer"; // from是关键字，后面是类名，关键字是不区分大小写的，但是类名是区分的
        // 2.通过session.createQuery(hql)去把HQL语句作为参数传递
        List<Customer> list = session.createQuery(hql).list();
        System.out.println(list.get(0));

        session.getTransaction().commit();
        session.close();
    }

    // 排序检索——查询订单，根据订单的价格进行排序
    @Test
    public void test3() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 1.定义HQL语句
        String hql = "from Order order by money desc"; // desc：降序，默认是asc(升序)
        // 2.执行hql语句，根据价格进行排序
        List<Order> list = session.createQuery(hql).list();

        System.out.println(list);

        session.getTransaction().commit();
        session.close();
    }

    // 条件查询
    @Test
    public void test4() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 1根据位置来绑定参数
        // 1.1创建hql语句
        String hql = "from Order where money > ?";

        // 1.2执行hql语句
        List<Order> list = session.createQuery(hql).setParameter(0, 2000d).list();
        // 可以使用例如setString()、setDouble这样的方法来添加参数，参数的序号是从0开始

        /*// 2.根据名称来绑定
        // 1.1创建hql语句
        String hql = "from Order where money > :mymoney";

        // 1.2执行hql语句
        List<Order> list = session.createQuery(hql).setParameter("mymoney", 2000d).list();*/

        System.out.println(list);

        session.getTransaction().commit();
        session.close();
    }

    // 分组统计操作
    @Test
    public void test6() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 统计操作——统计一共有多少订单（count）
        String hql = "select count(*) from Order";

        Object count = session.createQuery(hql).uniqueResult();
        System.out.println(count);

        session.getTransaction().commit();
        session.close();
    }

    // 分组统计操作
    @Test
    public void test7() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 分组统计——每一个人的订单总价()
        String hql = "select sum(money) from Order group by c";
        List list = session.createQuery(hql).list();
        System.out.println(list);

        session.getTransaction().commit();
        session.close();
    }

    // 投影查询
    @Test
    public void test8() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 1.查询出所有的Customer的name
        String hql = "select name from Customer";

        List list = session.createQuery(hql).list();
        System.out.println(list); // [武松, 潘金莲]

        // 如果只查询一个列，得到的结果是List<Object>

        session.getTransaction().commit();
        session.close();
    }

    // 投影查询
    @Test
    public void test9() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 2.查询所有的Customer的id, name
        String hql = "select id,name from Customer";
        // 如果是查询多列，那么得到的结果是List<Object[]>
        List list = session.createQuery(hql).list();
        System.out.println(list);

        session.getTransaction().commit();
        session.close();
    }

    // 投影查询
    @Test
    public void test10() {
        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 2.查询所有的Customer的id, name
        String hql = "select id,name from Customer";
        List<Object[]> list = session.createQuery(hql).list();
        for (Object[] objs : list) {
            for (Object obj : objs) {
                System.out.print(obj + "   ");
            }
            System.out.println();
        }
        // 如果是查询多列，得到的结果是List<Object[]>

        session.getTransaction().commit();
        session.close();
    }

}
