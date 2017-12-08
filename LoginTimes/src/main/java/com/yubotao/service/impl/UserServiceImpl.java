package com.yubotao.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yubotao.Dao.UserMapper;
import com.yubotao.POJO.User;
import com.yubotao.service.UserService;

@Service
public class UserServiceImpl implements UserService{
   
	private static final Log log = LogFactory.getLog(UserServiceImpl.class);
	
	@Autowired
	UserMapper userMapper;
	
	public User getUserById(Long id){
		return userMapper.selectByPrimaryKey(id);
	}
	
	public User getUserByUsername(String username){
		return userMapper.selectByUsername(username);
	}
	
	public boolean updateUser(User user){
		int flag = userMapper.updateByPrimaryKey(user);
		if(flag == 1){
			return true;
		}
		return false;
	}
	
}
