import entity.AnotherUser;
import entity.FatherUser;
import entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yubotao on 2017/09/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml"})
public class BeansTest {
    
    @Test
    public void method1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        User user1 =(User) applicationContext.getBean("user");
        
        user1.setFirstName("YU");
        user1.setLastName("Botao");
    
        System.out.println(user1);
    }
    
    @Autowired
    AnotherUser anotherUser;
    
    @Test
    public void method2(){
        anotherUser.setFirstName("YU");
        anotherUser.setLastName("Botao");
    
        System.out.println(anotherUser);
    }
    
    @Autowired
    FatherUser fatherUser;
    
    @Test
    public void ref(){
        fatherUser.setAge(18);
        fatherUser.setPower("*");
    
        System.out.println(fatherUser);
    }
}
