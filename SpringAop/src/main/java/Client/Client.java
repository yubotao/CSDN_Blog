package Client;

import Dao.AccountDao;
import Dao.UserDao;
import POJO.User;
import POJO.UserFactory;
import Service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.CreateTables;

/**
 * Created by yubotao on 2017/09/25.
 */
public class Client {
    public static void main(String[] args) {
        //定义配置文件路径
        String path = "classpath:Transaction.xml";
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
        //获取CreateTables实例
        CreateTables tables = (CreateTables) applicationContext.getBean("createTables");
        //创建t_user表
        String create_user = "create table t_user(userid int primary key auto_increment, username varchar(20), password varchar(32))";
        tables.createTable(create_user);
        //创建工资表,工资表的userid关联t_user表的userid
        String create_account = "create table account(userid int primary key auto_increment, account double, foreign key(userid) references t_user(userid) on delete cascade on update cascade)";
        tables.createTable(create_account);
        //创建用户
        User user1 = new UserFactory().createUser("张三", 1, "zhangsan");
        User user2 = new UserFactory().createUser("李四", 2, "lisi");
        User user3 = new UserFactory().createUser("王五", 3, "wangwu");
        User user4 = new UserFactory().createUser("赵六", 4, "zhaoliu");
        //获取用户数据访问对象
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        System.out.println(userDao.addUser(user1));
        System.out.println(userDao.addUser(user2));
        System.out.println(userDao.addUser(user3));
        System.out.println(userDao.addUser(user4));
        //获取存款数据访问对象
        AccountDao account = (AccountDao) applicationContext.getBean("accountDao");
        account.addAccount(1, 100);
        account.addAccount(2, 290.5);
        account.addAccount(3, 30.5);
        account.addAccount(4, 50);
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.transfer(user1, user3, 10);
}
}
