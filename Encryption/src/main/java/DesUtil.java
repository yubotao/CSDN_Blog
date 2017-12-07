import javax.crypto.Cipher;
import java.security.Key;
import java.security.Security;

/**
 * Created by Administrator on 2017/08/19.
 */
public class DesUtil {
    private static final String ENCRYPT_TYPE = "DES";
    //字符串默认值
    private static String defaultKey = "";
    //加密工具
    private Cipher encryptCipher = null;
    //解密工具
    private Cipher decryptCipher = null;
    
    public DesUtil() throws Exception{
        this(defaultKey);
    }
    
    /**
     * 指定密钥构造方法
     *
     * @param strKey
     *            指定的密钥
     * @throws Exception
     */
    public DesUtil(String strKey) throws Exception{
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        Key key = getKey(strKey.getBytes());
        encryptCipher = Cipher.getInstance(ENCRYPT_TYPE);
        encryptCipher.init(Cipher.ENCRYPT_MODE, key);
        decryptCipher = Cipher.getInstance(ENCRYPT_TYPE);
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
    }
    
    /**
     * 加密字节数组
     *
     * @param arr
     *            需加密的字节数组
     * @return 加密后的字节数组
     * @throws Exception
     */
    private byte[] encryptStr(byte[] arr) throws Exception {
        return encryptCipher.doFinal(arr);
    }
    
    /**
     * 加密字符串
     *
     * @param strIn
     *            需加密的字符串
     * @return 加密后的字符串
     * @throws Exception
     */
    public String encrypt(String strIn) throws Exception {
        return StrConvertUtil.byteArrToHexStr(encryptStr(strIn.getBytes()));
    }
    
    /**
     * 解密字节数组
     *
     * @param arr
     *            需解密的字节数组
     * @return 解密后的字节数组
     * @throws Exception
     */
    private byte[] decryptStr(byte[] arr) throws Exception {
        return decryptCipher.doFinal(arr);
    }
    
    /**
     * 解密字符串
     *
     * @param strIn
     *            需解密的字符串
     * @return 解密后的字符串
     * @throws Exception
     */
    public String decrypt(String strIn) throws Exception {
        return new String(decryptStr(StrConvertUtil.hexStrToByteArr(strIn)));
    }
    
    /**
     * 从指定字符串生成密钥，密钥所需的字节数组长度为8位。不足8位时后面补0，超出8位只取前8位
     *
     * @param arrBTmp
     *            构成该字符串的字节数组
     * @return 生成的密钥
     */
    private Key getKey(byte[] arrBTmp) {
        byte[] arrB = new byte[8];// 创建一个空的8位字节数组（默认值为0）
        // 将原始字节数组转换为8位
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        Key key = new javax.crypto.spec.SecretKeySpec(arrB, ENCRYPT_TYPE);// 生成密钥
        return key;
    }
    
}
