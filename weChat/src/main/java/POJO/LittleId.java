package POJO;

import java.util.List;

/**
 * Created by yubotao on 2017/11/17.
 */
public class LittleId {
    private List<String> openid;
    
    public List<String> getOpenid() {
        return openid;
    }
    
    public void setOpenid(List<String> openid) {
        this.openid = openid;
    }
    
    @Override
    public String toString() {
        return "LittleId{" +
                "openid=" + openid +
                '}';
    }
}
