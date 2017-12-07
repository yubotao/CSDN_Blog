import org.junit.Test;

/**
 * Created by yubotao on 2017/12/07.
 */
public class ETest {
    
    @Test
    public void getMD5(){
       try {
           DesUtil des = new DesUtil("JAVA");
    
           String username = "admin";
           Long logTime = System.currentTimeMillis();
           String time  = "" +logTime;
           String last = username + "," + time;
    
           String fff = des.encrypt(last);
           System.out.println("加密后：" + fff);
    
           String defff = des.decrypt(fff);
           System.out.println("解密后：" + defff);
    
           String[] sArr = defff.split(",");
    
           String user1 = sArr[0];
    
           String time1 = sArr[1];
    
           System.out.println(user1);
    
           System.out.println(time1);
    
           Long logTime1 = Long.parseLong(time1);
    
           System.out.println("转换为Long型：" + logTime1);
       }catch (Exception e){
           e.printStackTrace();
       }
    }
    
    @Test
    public void getDes(){
        String src = "5555";
        String src1 = Md5Util.getMd5(src);
        System.out.println("MD5加密前：" + src);
        System.out.println("MD5加完了：" + src1);
    }
    
    @Test
    public void getSHA1(){
        String before = "5555";
        String after = SHA1Util.getSHA_1(before);
        System.out.println("SHA-1加密前： " + before);
        System.out.println("SHA-1加密后： " + after);
    }
    
}
