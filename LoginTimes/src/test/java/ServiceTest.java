

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yubotao.POJO.User;
import com.yubotao.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class ServiceTest {
	
	@Autowired
	UserService userService;
	
	@Test
	public void test(){
		User user = userService.getUserByUsername("yubotao");
		System.out.println(user);
		user.setLastlogin(System.currentTimeMillis());
		System.out.println(user);
		System.out.println(userService.updateUser(user));
	}

}
