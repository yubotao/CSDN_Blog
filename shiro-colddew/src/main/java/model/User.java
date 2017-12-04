package model; /**
 * Created by yubotao on 2017/12/03.
 */
/**
 * shiro库user表
 * */
public class User {
    
    private Long id;
    private String name;
    private String password;
    private Long role;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Long getRole() {
        return role;
    }
    
    public void setRole(Long role) {
        this.role = role;
    }
    
    @Override
    public String toString() {
        return "model.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
