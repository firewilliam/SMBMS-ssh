package com.xb.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.xb.dao.RoleDao;
import com.xb.entity.Role;

public class RoleDaoImpl extends HibernateDaoSupport implements RoleDao{

	@Override
	public List<Role> getRoleList() {
		System.out.println("111111");
		List<Role> list=null;
		try {
			list = this.getHibernateTemplate().find("select id,roleName from Role");
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("22222");
		if(list!=null&&list.size()>0){
			System.out.println("3333333");
			for(Role r:list){
				System.out.println(r.getRoleName());
			}
			System.out.println("44444");
			return list;
		}
		return null;
	}

}
