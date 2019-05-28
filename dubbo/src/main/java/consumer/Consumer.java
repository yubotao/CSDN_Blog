package consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.DemoService;
import service.TestRmiService;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 15:57 2018/3/8
 * @Modified By:
 */
public class Consumer {
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:consumer.xml"});
        context.start();
        // obtain proxy object for remote invocation
        DemoService demoService = (DemoService) context.getBean("demoService");
//        TestRmiService rmiService = (TestRmiService) context.getBean("rmiService");
        // execute remote invocation
        long before = System.currentTimeMillis();
        String hello = demoService.sayHello("world");
//        String fuck = rmiService.FuckHello("you");
        long timeElapsed = System.currentTimeMillis() - before;
        // show the result
        System.out.println(timeElapsed);
        System.out.println(hello);
//        System.out.println(fuck);
        before = System.currentTimeMillis();
        hello = demoService.sayHello("world");
        timeElapsed = System.currentTimeMillis() - before;
        System.out.println(timeElapsed);
        System.out.println(hello);

        before = System.currentTimeMillis();
        String hhh = demoService.sayHello("fff~fuck");
        timeElapsed = System.currentTimeMillis() - before;
        System.out.println(timeElapsed);
        System.out.println(hhh);
    }
}
