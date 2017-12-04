import model.Role;
import model.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.RoleService;
import service.UserService;

/**
 * Created by yubotao on 2017/12/03.
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-service.xml"})
public class ServiceTest {
    
    @Autowired
    UserService userService;
    
    @Autowired
    RoleService roleService;
    
    @Test
    public void UserTest(){
        User user = userService.getUserById(1L);
        System.out.println(user);
    }
    
    @Test
    public void RoleTest(){
        Role role = roleService.getRoleById(1L);
        System.out.println(role);
    }
    
}
