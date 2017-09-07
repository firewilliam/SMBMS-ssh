package com.xb.action;

import java.util.List;


import com.alibaba.fastjson.JSONArray;
import com.xb.entity.Role;
import com.xb.service.RoleService;

public class RoleAction {
	private RoleService roleService;
	private List<Role> roleList;
	private JSONArray data;
	
	
	public String getRoleList(){
		List<Role> result=roleService.getRoleList();
		if(result!=null&&result.size()>0){
			roleList=result;
			for(Role r:roleList){
				System.out.println(r.getRoleName());
			}
			
				data=new JSONArray();
				data.addAll(roleList);
			
			return "success";
		}
		
		return "none";
	}

	
	
	
	


	

	

	public JSONArray getData() {
		return data;
	}

	public void setData(JSONArray data) {
		this.data = data;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
}
