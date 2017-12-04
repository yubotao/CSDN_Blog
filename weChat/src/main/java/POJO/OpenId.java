package POJO;

/**
 * Created by yubotao on 2017/11/17.
 */
public class OpenId {

    private String total;
    private String count;
    private LittleId data;
    private String next_openid;
    
    public String getTotal() {
        return total;
    }
    
    public void setTotal(String total) {
        this.total = total;
    }
    
    public String getCount() {
        return count;
    }
    
    public void setCount(String count) {
        this.count = count;
    }
    
    public LittleId getData() {
        return data;
    }
    
    public void setData(LittleId data) {
        this.data = data;
    }
    
    public String getNext_openid() {
        return next_openid;
    }
    
    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }
    
    
    @Override
    public String toString() {
        return "OpenId{" +
                "total='" + total + '\'' +
                ", count='" + count + '\'' +
                ", data=" + data +
                ", next_openid='" + next_openid + '\'' +
                '}';
    }
    
    
    
    
}
