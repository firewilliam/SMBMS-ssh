package com.xb.action;

import com.xb.entity.User;
import com.xb.service.UserService;

public class UserAction {
	private UserService userService;
	private User user;
	
	public String login(){
		User result=userService.login(user);
		if(result!=null&&result.getUserPassword().equals(user.getUserPassword())){
			return "success";
		}else{
			return "input";
		}
	}
	
	
	
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
