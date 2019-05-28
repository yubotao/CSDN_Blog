package Dao;
import POJO.User;
import java.util.List;

/**
 * Created by yubotao on 2017/09/25.
 */
public interface UserDao {
    public int addUser(User user);
    public int updateUser(User user);
    public int deleteUser(User user);
    public User findUserByID(int id);
    public List<User> findAllUser();
}
