package com.xb.dao;

import java.util.List;

import com.xb.entity.User;

public interface UserDao {
	public User findByUser(User user);
	public List<User> getUserList();
}
