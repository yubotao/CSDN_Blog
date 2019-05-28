import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.DemoService;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 17:49 2018/3/8
 * @Modified By:
 */
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        DemoService demoService = (DemoService) context.getBean(DemoService.class);
        System.out.println(demoService.getPermissions(1L));
    }
}
