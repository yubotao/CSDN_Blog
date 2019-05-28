package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yubotao on 2017/09/28.
 */
@Controller
public class HelloController {
    
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String getHW(){
        return "hello";
    }
}
