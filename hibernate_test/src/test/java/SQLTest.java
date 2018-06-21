import com.yubotao.hibernate.manyToOne.Customer;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import java.util.List;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:43 2018/6/21
 * @Modified By:
 */
public class SQLTest {
    // 测试执行本地sql
    @Test
    public void test1() {

        Session session = HibernateUtils.openSession();
        session.beginTransaction();

        // 执行本地sql
        SQLQuery sqlQuery = session.createSQLQuery("select * from t_customer");
        // List list = sqlQuery.list();
        // System.out.println(list);

        // List<Object[]> list = sqlQuery.list();

        sqlQuery.addEntity(Customer.class); // 如何能得到一个对象呢？
        // 将查询结果绑定到指定对象
        List list = sqlQuery.list();
        System.out.println(list);

        session.getTransaction().commit();
        session.close();

    }
}
