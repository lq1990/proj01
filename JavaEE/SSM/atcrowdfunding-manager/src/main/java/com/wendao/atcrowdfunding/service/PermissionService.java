package com.wendao.atcrowdfunding.service;

import java.util.List;

import com.wendao.atcrowdfunding.bean.Permission;

public interface PermissionService {

	Permission queryRootPermission();
	
	
	List<Permission> queryAll();
	
	List<Permission> queryChildPermissions(Integer pid);


	void insertPermission(Permission perm);


	Permission queryById(Integer id);


	void updatePermission(Permission perm);

	
}
