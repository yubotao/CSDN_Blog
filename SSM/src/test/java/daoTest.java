import com.yubotao.Dao.PersonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yubotao on 2017/12/05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class daoTest {
    
    @Autowired
    PersonMapper personMapper;
    
    @Test
    public void test(){
//        Person person = new Person();
//        person.setName("yubotao");
//        person.setAge(18);
//        person.setSex("male");
//
//        personMapper.insert(person);
        System.out.println(personMapper.selectByPrimaryKey(1L));
    }
    
}
