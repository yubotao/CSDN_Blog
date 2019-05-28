package util;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yubotao on 2017/09/25.
 */
public class LogHandler {
    
    private static Logger loggerAdvice = Logger.getLogger(LogHandler.class);
    
    //切入点执行之前需要执行的方法
    public void LogBefore(){
        System.out.println("转账开始时间:" + System.currentTimeMillis());
    }
    //切入点执行结束执行该方法
    public void LogAfter(){
        System.out.println("转账结束时间:" + System.currentTimeMillis());
    }
    
    public Object around(ProceedingJoinPoint pip)throws Throwable{
        //获取组件类名
        String className = pip.getTarget().getClass().getName();
        //获取调用方法名
        String method = pip.getSignature().getName();
        //取得数据库连接前时间
        long begin = System.currentTimeMillis();
        //当前系统时间
        String date = new SimpleDateFormat("yyyy-MM-dd:mm:ss").format(new Date());
        Object obj = pip.proceed();
        
        //取得数据库连接后时间
        long end = System.currentTimeMillis();
        //数据库响应时间
        int sqlTime = (int) (end-begin);
        String msg = date + "，执行了" + className + "." + method + "()";
    
        System.out.println(msg + "\t数据库响应时间： " + sqlTime);
        loggerAdvice.warn(msg + "\t数据库响应时间： " + sqlTime);
        return obj;
    }
}
