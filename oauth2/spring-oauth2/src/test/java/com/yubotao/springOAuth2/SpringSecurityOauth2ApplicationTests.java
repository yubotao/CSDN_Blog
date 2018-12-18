package com.yubotao.springOAuth2;

import com.yubotao.springOAuth2.jpa.AccountJpa;
import com.yubotao.springOAuth2.jpa.RoleJpa;
import com.yubotao.springOAuth2.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecurityOauth2ApplicationTests {

    @Autowired
    AccountJpa accountJpa;
    @Autowired
    RoleJpa roleJpa;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test(){
//        Account account = new Account();
//        account.setUsername("admin");
//        account.setPassword("admin");
//        accountJpa.save(account);
        Role role = new Role();
        role.setName("master");
        roleJpa.save(role);
    }

}
