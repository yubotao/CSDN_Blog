package com.yubotao.test.copy;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: yubt
 * @description:
 * @date: Created in 17:12 2021/05/20
 * @modified By:
 */
public class DateUtil {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(Date date){
        return dateFormat.format(date);
    }

    public static Date parse(String dateStr) throws ParseException {
        return dateFormat.parse(dateStr);
    }

}
