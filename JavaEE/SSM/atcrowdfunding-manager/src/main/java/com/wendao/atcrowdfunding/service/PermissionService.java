package com.wendao.atcrowdfunding.service;

import java.util.List;

import com.wendao.atcrowdfunding.bean.Permission;
import com.wendao.atcrowdfunding.bean.User;

public interface PermissionService {

	Permission queryRootPermission();
	
	
	List<Permission> queryAll();
	
	List<Permission> queryChildPermissions(Integer pid);


	void insertPermission(Permission perm);


	Permission queryById(Integer id);


	void updatePermission(Permission perm);


	void deletePermission(Permission perm);


	List<Integer> queryPermissionsByRoleid(Integer roleid);


	List<Permission> queryPermissionsByUser(User dbUser);

	
}
