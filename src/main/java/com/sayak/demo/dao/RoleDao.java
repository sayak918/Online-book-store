package com.sayak.demo.dao;


import com.sayak.demo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
