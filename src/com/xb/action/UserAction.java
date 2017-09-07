package com.xb.action;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionContext;
import com.xb.entity.User;
import com.xb.service.UserService;

public class UserAction {
	private UserService userService;
	private User user;
	private List<User> userList;
	private String error;
	private Map<String, Object> userSession;
	private String method;
	private JSONArray data;
	private String userCode;

	//方法分流
	public String user(){
		if(method.equals("list")){
			return "list";
		}else if(method.equals("getrolelist")){
			return "roleList";
		}else if(method.equals("add")){
			return "addNewUser";
		}else if(method.equals("ucexist")){
			return this.checkUserCode();
		}
		return null;
	}


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

	public String addNewUser(){
		Integer i=userService.addNewUser(user);
		if(i==1){
			return "success";
		}
		return "none";

	}
	public String checkUserCode(){
		if(!userService.checkUserCode(userCode)){
			userCode="exist";
		}

		data=new JSONArray();
		data.add(userCode);

		return "success";
	}







	public String getUserCode() {
		return userCode;
	}


	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}


	public JSONArray getData() {
		return data;
	}


	public void setData(JSONArray data) {
		this.data = data;
	}


	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
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
