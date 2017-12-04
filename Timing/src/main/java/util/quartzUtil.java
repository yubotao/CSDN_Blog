package util;

import java.text.SimpleDateFormat;

/**
 * Created by yubotao on 2017/11/21.
 */
/**
 * spring-quartz的定时器的具体实现方法
 * */
public class quartzUtil {

   public void test(){
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       System.out.println("start? " + simpleDateFormat.format(System.currentTimeMillis()));
   }

}
