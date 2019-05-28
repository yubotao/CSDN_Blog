import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 11:51 2018/6/21
 * @Modified By:
 */
public class HibernateUtils {
    private static Configuration config;
    private static SessionFactory sessionFactory;

    static {
        config = new Configuration().configure();
        sessionFactory = config.buildSessionFactory();
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }
}
