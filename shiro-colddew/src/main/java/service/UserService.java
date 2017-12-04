package service;

import model.User;

/**
 * Created by yubotao on 2017/12/03.
 */
public interface UserService {
    
    public boolean insert(User user);
    
    public boolean delete(Long id);
    
    public boolean update(User user);
    
    public User getUserById(Long id);
    
    public User getUserByName(String name);
    
}
