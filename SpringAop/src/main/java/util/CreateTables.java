package util;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by yubotao on 2017/09/25.
 */
public class CreateTables {
    //通过JdbcTemplate对象创建表
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbc){
        jdbcTemplate = jdbc;
    }
    public void createTable(String sql){
        jdbcTemplate.execute(sql);
    }
}
