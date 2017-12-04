package model; /**
 * Created by yubotao on 2017/12/03.
 */
/**
 * shiro库role表
 * */
public class Role {
    
    private Long id;
    private String name;
    private String permission;
    
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
    
    public String getPermission() {
        return permission;
    }
    
    public void setPermission(String permission) {
        this.permission = permission;
    }
    
    @Override
    public String toString() {
        return "model.Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
