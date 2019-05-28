import Dao.UserDao;
import POJO.User;
import Service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yubotao on 2017/09/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:Transaction.xml"})
public class service {
    
    @Autowired
    AccountService accountService;
    
    @Autowired
    UserDao userDao;
    
    @Test
    public void t(){
        
        User user1 = userDao.findUserByID(1);
        User user2 = userDao.findUserByID(2);
        
        accountService.transfer(user1,user2,5);
    }
}
