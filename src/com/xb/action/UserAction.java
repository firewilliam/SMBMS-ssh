package com.xb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.xb.entity.User;
import com.xb.service.UserService;

public class UserAction {
	private UserService userService;
	private User user;
	private List<User> userList;
	private String error;
	
	public String login(){
		User result=userService.login(user);
		if(result!=null&&result.getUserPassword().equals(user.getUserPassword())){
			String userName=result.getUserName();
			System.out.println(userName);
			ActionContext.getContext().getSession().put("userSession", userName);
			return "success";
		}else{
			error="用户不存在";
			return "input";
		}
	}
	
	public String list(){
		List<User> result=userService.getUserList();
		if(result!=null){
			userList=result;
			return "success";
		}else{
			return "none";
		}
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
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
