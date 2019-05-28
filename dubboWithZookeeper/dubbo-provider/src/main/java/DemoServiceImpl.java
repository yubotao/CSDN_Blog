import service.DemoService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 17:34 2018/3/8
 * @Modified By:
 */
public class DemoServiceImpl implements DemoService {
    public List<String> getPermissions(Long id) {
        List<String> demo = new ArrayList<String>();
        demo.add(String.format("Permission_%d", id - 1));
        demo.add(String.format("Permission_%d", id));
        demo.add(String.format("Permission_%d", id + 1));
        return demo;
    }
}
