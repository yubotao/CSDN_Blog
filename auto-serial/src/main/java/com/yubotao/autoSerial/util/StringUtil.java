package com.yubotao.autoSerial.util;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 14:47 2019/5/29
 * @Modified By:
 */
public class StringUtil {
    public static boolean isNotBlank(String words){
        if (words != null && !"".equals(words)){
            return true;
        }
        return false;
    }
}
