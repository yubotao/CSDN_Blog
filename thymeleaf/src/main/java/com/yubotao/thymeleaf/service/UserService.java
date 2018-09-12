package com.yubotao.thymeleaf.service;

import com.yubotao.thymeleaf.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:43 2018/9/7
 * @Modified By:
 */
@Service
public class UserService {

    public User findOneUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("李文强");
        user.setPassword("12345");
        user.setTelephone("15890904567");
        user.setRegisterTime(new Date());
        user.setPopedom(0);
        return user;
    }

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<User>();

        User user = new User();
        user.setId(1);
        user.setUsername("李文强");
        user.setPassword("12345");
        user.setTelephone("15890904567");
        user.setRegisterTime(new Date());
        user.setPopedom(0);
        users.add(user);

        user = new User();
        user.setId(2);
        user.setUsername("张海洋");
        user.setPassword("11111");
        user.setTelephone("13990904567");
        user.setRegisterTime(new Date());
        user.setPopedom(1);
        users.add(user);

        user = new User();
        user.setId(3);
        user.setUsername("吴文燕");
        user.setPassword("22222");
        user.setTelephone("15890978905");
        user.setRegisterTime(new Date());
        user.setPopedom(1);
        users.add(user);

        user = new User();
        user.setId(4);
        user.setUsername("郑智化");
        user.setPassword("33333");
        user.setTelephone("15990956905");
        user.setRegisterTime(new Date());
        user.setPopedom(1);
        users.add(user);

        return users;
    }

}
