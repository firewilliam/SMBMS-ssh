package com.xb.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xb.dao.UserDao;
import com.xb.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User findByUser(User user) {
		String hql="from User where userCode=? and userPassword=?";
		List<User> list=this.getHibernateTemplate().find(hql,new String[]{user.getUserCode(),user.getUserPassword()});
		if(list!=null&&list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<User> getUserList() {
		String hql="from User";
		List<User> list=this.getHibernateTemplate().find(hql);
		
		return list;
	}

}
