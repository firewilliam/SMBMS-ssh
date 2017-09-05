package com.xb.service.impl;

import com.xb.dao.UserDao;
import com.xb.entity.User;
import com.xb.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;

	@Override
	public User login(User user) {
		User result=userDao.findByUser(user);
		if(result!=null){
			return result;
		}
		else{
			return null;
		}
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}
