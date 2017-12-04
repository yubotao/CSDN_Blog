package dao;

import model.User;

/**
 * Created by yubotao on 2017/12/03.
 */
public interface UserDao {
    
    public Integer insert(User user);
    
    public Integer delete(Long id);
    
    public Integer update(User user);
    
    public User getUserById(Long id);
    
    public User getUserByName(String name);
    
}
