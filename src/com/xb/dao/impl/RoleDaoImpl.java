package com.xb.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xb.dao.RoleDao;
import com.xb.entity.Role;

public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao{

	@Override
	public List<Role> getRoleList() {
		List<Role> list=null;
		
			list = this.getHibernateTemplate().find("from Role");
		
		if(list!=null&&list.size()>0){
			
			return list;
		}
		return null;
	}

}
