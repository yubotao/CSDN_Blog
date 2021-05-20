package com.yubotao.CookieAndSession;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yubotao.POJO.User;
import com.yubotao.service.UserService;

@Controller
public class CASController {
	
	private static final Log log = LogFactory.getLog(CASController.class);
	
	@Autowired
	UserService userService;
	
	 @RequestMapping(value = "/login",method = RequestMethod.GET)
	 public String getlog(Map<String,Object> map){
	        map.put("user",new User());
	        return "login";
	 }
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String login(HttpServletRequest request,HttpServletResponse response,User u) throws ServletException,IOException{
		
		String username = u.getUsername();
		String password = u.getPassword();
		
		if(username == null || password == null){
			return "paramsNull";
		}
		
		User realUser = userService.getUserByUsername(username);
		Long loginTime = System.currentTimeMillis();
		Integer wrongTimes = null;
		Integer locked = null;
		
		if(realUser == null){
			return "objectNull";
		}
		
		if((loginTime - realUser.getLastlogin()) > 24*3600*1000){
			realUser.setWrongtimes(0);
	
			realUser.setLocked(0);
			userService.updateUser(realUser);
		}
			
		if(realUser.getLocked() == 0){
			if((loginTime - realUser.getLastlogin()) > 5*60*1000){
				realUser.setLastlogin(loginTime);
				if(password.equals(realUser.getPassword())){
					
					userService.updateUser(realUser);
					return "success";
				}else{
					wrongTimes = realUser.getWrongtimes() + 1;
					if(wrongTimes > 2){
						locked = 1;
						realUser.setLocked(locked);
					}
					realUser.setWrongtimes(wrongTimes);
					userService.updateUser(realUser);
					return "pwWrong";
				}
			}else
				return "in5m";
		}
		
		return "fail";
		
	}

}
