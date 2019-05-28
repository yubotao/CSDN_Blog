package com.yubotao.thymeleaf;

import com.yubotao.thymeleaf.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThymeleafApplicationTests {

    @Test
    public void contextLoads() {
        User user = new User();
        user.setUsername("fuck");
        System.out.println(user);
    }

}
