package service.impl;

import service.DemoService;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 15:46 2018/3/8
 * @Modified By:
 */
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        try {
            SECONDS.sleep(5);
        }catch (Exception ignored) {}
            return "Hello " + name;
    }
}
