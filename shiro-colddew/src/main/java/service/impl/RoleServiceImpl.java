package service.impl;

import dao.RoleDao;
import model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.RoleService;

/**
 * Created by yubotao on 2017/12/03.
 */
@Service
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    RoleDao roleDao;
    
    public boolean insert(Role role){
        Integer flag = roleDao.insert(role);
        if(flag > 0){
            return true;
        }
        return false;
    }
    
    public boolean delete(Long id){
        Integer flag = roleDao.delete(id);
        if(flag > 0){
            return true;
        }
        return false;
    }
    
    public boolean update(Role role){
        Integer flag = roleDao.update(role);
        if(flag > 0){
            return true;
        }
        return false;
    }
    
    public Role getRoleById(Long id){
        Role role = roleDao.getRoleById(id);
        return role;
    }
    
}
