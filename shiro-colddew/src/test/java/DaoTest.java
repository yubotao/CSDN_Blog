import dao.RoleDao;
import dao.UserDao;
import model.Role;
import model.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yubotao on 2017/12/03.
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class DaoTest {
    
    @Autowired
    RoleDao roleDao;
    
    @Autowired
    UserDao userDao;
    
    @Test
    public void userDaoTest(){
//        User user = new User();
//        user.setName("yu");
//        user.setPassword("123");
//        user.setRole(1L);
//        Integer id = userDao.insert(user);
//        System.out.println(user.getId());
//        userDao.delete(2L);
        User user = userDao.getUserById(3L);
        System.out.println(user);
    }
    
    @Test
    public void roleDaoTest(){
        Role role = new Role();
        role.setName("admin");
        role.setPermission("1,2,3");
        roleDao.insert(role);
    }
    
}
