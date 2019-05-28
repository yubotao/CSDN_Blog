package Daoimpl;

import Dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by yubotao on 2017/09/25.
 */
public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbc){
        this.jdbcTemplate = jdbc;
    }
    
    public void addAccount(int id, double account) {
        // TODO Auto-generated method stub
        String sql = "insert into account values(" + id + "," + account + ")";
        this.jdbcTemplate.execute(sql);
    }
    
   
    public void inAccount(int id, double account) {
        // TODO Auto-generated method stub
        String sql = "update account set account=account+? where userid=?";
        this.jdbcTemplate.update(sql, account,id);
    }
    
  
    public void outAccount(int id, double account) {
        // TODO Auto-generated method stub
        String sql = "update account set account=account-? where userid=?";
        this.jdbcTemplate.update(sql, account,id);
    }
}
