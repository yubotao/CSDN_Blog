package com.yubotao.service;

import com.yubotao.POJO.User;

public interface UserService {
	
	public User getUserById(Long id);
	
	public User getUserByUsername(String username);
	
	public boolean updateUser(User user);

}
