package com.yubotao.sbaop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Auther: yubt
 * @Description:  日志切面
 * @Date: Created in 16:52 2018/11/23
 * @Modified By:
 */
// @Aspect 作用是把当前类标识为一个切面供容器读取
@Aspect
@Component
public class LogAspect {
    // (..) 表示方法的参数，两个"."表示任何参数
    @Pointcut("execution(public * com.yubotao.sbaop.controller.LogController.first(..))")
    public void webLog(){
        System.out.println("切入方法打印日志");
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable{
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("方法的返回值 : " + ret);
    }

    // 后置异常通知， 不能与@Around共用，否则会失效
    @Order(1)
    @AfterThrowing(pointcut = "execution(* com.yubotao.sbaop.controller.LogController.error(..))", throwing = "ex")
    public void throwsLogs(JoinPoint jp, Exception ex){
        System.out.println("方法异常时执行.....");
        System.out.println("异常为： " + ex);
    }

    // 后置最终通知， final增强，不管是抛出异常或者正常退出都会执行
    @After("webLog()")
    public void after(JoinPoint jp){
        System.out.println("方法最后执行.....");
    }

    // 环绕通知，环绕增强，相当于MethodInterceptor
    @Around("webLog()")
    public Object around(ProceedingJoinPoint pjp){
        System.out.println("方法环绕start......");
        try{
            Object o = pjp.proceed();
            System.out.println("方法环绕proceed，结果是：" + o);
            return o;
        }catch (Throwable e){
            e.printStackTrace();
            return null;
        }
    }

}
