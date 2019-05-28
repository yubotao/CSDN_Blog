package Daoimpl;

import Dao.UserDao;
import POJO.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * Created by yubotao on 2017/09/25.
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate(JdbcTemplate jdbc){
        this.jdbcTemplate = jdbc;
    }
    
    public int addUser(User user) {
        // TODO Auto-generated method stub
        String sql = "insert into t_user(userid,username,password)values(?,?,?)";
        Object[] obj = new Object[]{
                user.getUserID(),
                user.getUserName(),
                user.getPassword()
        };
        return this.execute(sql, obj);
    }
    
    
    public int updateUser(User user) {
        // TODO Auto-generated method stub
        String sql = "update t_user set username=?,password=? where userid=?";
        Object[] obj = new Object[]{
                user.getUserName(),
                user.getPassword(),
                user.getUserID()
        };
        return this.execute(sql, obj);
    }
    
    
    public int deleteUser(User user) {
        // TODO Auto-generated method stub
        String sql = "delete from t_user where userid=?";
        Object[] obj = new Object[]{
                user.getUserID()
        };
        return this.execute(sql, obj);
    }
    private int execute(String sql, Object[] obj){
        return this.jdbcTemplate.update(sql, obj);
    }
    
    public User findUserByID(int id) {
        // TODO Auto-generated method stub
        String sql = "select * from t_user where userid=?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper(User.class);
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
    
    public List<User> findAllUser() {
        // TODO Auto-generated method stub
        String sql = "select * from t_user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper(User.class);
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}
