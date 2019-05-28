import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 17:46 2018/3/8
 * @Modified By:
 */
public class Provider {
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        context.start();
        System.in.read();
    }
}
