package com.xb.service.impl;

import java.util.List;

import com.xb.dao.RoleDao;
import com.xb.entity.Role;
import com.xb.service.RoleService;

public class RoleServiceImpl implements RoleService {
	
	private RoleDao roleDao;
	
	@Override
	public List<Role> getRoleList() {
		// TODO Auto-generated method stub
		List<Role> result=roleDao.getRoleList();
		if(result!=null&&result.size()>0){
			return result;
		}
		return null;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	
	
}
