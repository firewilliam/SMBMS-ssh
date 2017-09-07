package com.xb.service.impl;

import java.util.List;

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

	@Override
	public List<User> getUserList() {
		List<User> result=userDao.getUserList();
		if(result!=null&&result.size()>0){
			return result;
		}else{
			return null;
		}
	}

	@Override
	public Integer addNewUser(User user) {
		Integer i=userDao.save(user);
		
		
		return i;
	}
	@Override
	public boolean checkUserCode(String userCode) {//返回false表示存在此用户，返回true表示此用户名可用
		User user=new User();
		user.setUserCode(userCode);
		User result=userDao.findByUser(user);
		if(result!=null&&result.getUserCode().equals(userCode)){
			return false;
		}
		
		return true;
	}

	
}
