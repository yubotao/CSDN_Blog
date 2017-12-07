import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/08/19.
 */
public class Md5Util {
    public final static String getMd5(String str){
        MessageDigest messageDigest = null;
        try{
            messageDigest = MessageDigest.getInstance("MD5");
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        //使用指定字节更新摘要
        messageDigest.update(str.getBytes());
        //获得密文
        byte[] md = messageDigest.digest();
        return StrConvertUtil.byteArrToHexStr(md);
    }
}
