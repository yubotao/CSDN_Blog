package controller;

import model.Role;
import model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.RoleService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by yubotao on 2017/12/03.
 */
@Controller
public class OneController {
    
    private static final Log log = LogFactory.getLog(OneController.class);
    
    @Autowired
    UserService userService;
    
    @Autowired
    RoleService roleService;
    
    @RequestMapping(value = "/a/login",method = RequestMethod.GET)
    public String getLogin(){
        return "login";
    }
    
    @RequestMapping(value = "/a/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, User user, Model model){
        if(user.getName() == null || user.getPassword() == null){
            return "/a/login/fail";
        }
        
        //开始登陆流程
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword());
            subject.login(token);
            log.info("登陆成功!");
            log.info(subject.isAuthenticated());
    
            User user1 = userService.getUserByName(user.getName());
            Role role = roleService.getRoleById(user1.getRole());
            log.info("user role's permission : " + role.getPermission());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }
    
    @RequestMapping(value = "/a/login/fail",method = RequestMethod.GET)
    public String logFail(){
        return "fail";
    }
    
    @RequestMapping(value = "/a/u/first",method = RequestMethod.GET)
    public String first(){
        return "first";
    }
    
    @RequestMapping(value = "/a/u/second",method = RequestMethod.GET)
    public String second(){
        return "second";
    }
    
    @RequestMapping(value = "/a/u/third",method = RequestMethod.GET)
    public String third(){
        return "third";
    }
    
}
