package com.xb.service;

import java.util.List;

import com.xb.entity.User;

public interface UserService {
	
	public User login(User user);
	public List<User> getUserList();
	public Integer addNewUser(User user);
	public boolean checkUserCode(String userCode);

}
