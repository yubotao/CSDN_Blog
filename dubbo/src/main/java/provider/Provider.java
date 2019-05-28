package provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 15:52 2018/3/8
 * @Modified By:
 */
public class Provider {
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:configure.xml"});
        context.start();
        // press any key to exit
        System.in.read();
    }
}
