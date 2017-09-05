package com.xb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xb.dao.UserDao;
import com.xb.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User findByUser(User user) {
		String hql="from User u where u.userCode=? and u.userPassword=?";
		List<User> list=this.getHibernateTemplate().find(hql,new String[]{user.getUserCode(),user.getUserPassword()});
		return list.get(0);
	}

}
