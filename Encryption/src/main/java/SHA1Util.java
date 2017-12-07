import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yubotao on 2017/12/07.
 */
public class SHA1Util {
    public final static String getSHA_1(String str){
        MessageDigest messageDigest = null;
        try{
            messageDigest = MessageDigest.getInstance("SHA-1");
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        //获得密文
        byte[] md = messageDigest.digest();
        return StrConvertUtil.byteArrToHexStr(md);
    }
}
