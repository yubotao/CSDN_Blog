package POJO;

/**
 * Created by yubotao on 2017/09/25.
 */
public class UserFactory {
    public User createUser(String name, int id, String password){
        User user = new User();
        user.setUserName(name);
        user.setUserID(id);
        user.setPassword(password);
        return user;
    }
}
