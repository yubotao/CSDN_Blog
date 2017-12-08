

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yubotao.Dao.UserMapper;
import com.yubotao.POJO.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class DaoTest {
	
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void test(){
//		User user = new User();
//		user.setUsername("yubotao");
//		user.setPassword("123");
//		user.setWrongtimes(0);
//		user.setLastlogin(System.currentTimeMillis());
//		
//		userMapper.insert(user);
		
		System.out.println(userMapper.selectByUsername("yubotao"));
		
	}

}
