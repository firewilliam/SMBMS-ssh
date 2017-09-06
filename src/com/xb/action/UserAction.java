package com.xb.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.xb.entity.User;
import com.xb.service.UserService;

public class UserAction {
	private UserService userService;
	private User user;
	private List<User> userList;
	private String error;
	private Map<String, Object> userSession;
	
	public String login(){
		User result=userService.login(user);
		if(result!=null&&result.getUserPassword().equals(user.getUserPassword())){
			//此处必须为userSession赋值为ActionContext.getContext().getSession()，否则为空指针
			userSession=ActionContext.getContext().getSession();
			userSession.put("userName", result.getUserName());
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
	
	
	
	

	
	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
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
