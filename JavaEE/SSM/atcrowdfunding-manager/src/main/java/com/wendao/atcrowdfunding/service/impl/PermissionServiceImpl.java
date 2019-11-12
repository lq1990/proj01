package com.wendao.atcrowdfunding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendao.atcrowdfunding.bean.Permission;
import com.wendao.atcrowdfunding.bean.User;
import com.wendao.atcrowdfunding.dao.PermissionDao;
import com.wendao.atcrowdfunding.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService{

	@Autowired
	private PermissionDao permissionDao;

	@Override
	public Permission queryRootPermission() {
		
		return permissionDao.queryRootPermission();
	}

	@Override
	public List<Permission> queryAll() {
		return permissionDao.queryAll();
	}

	@Override
	public List<Permission> queryChildPermissions(Integer pid) {
		return permissionDao.queryChildPermissions(pid);
	}

	@Override
	public void insertPermission(Permission perm) {

		permissionDao.insertPermission(perm);
	}

	@Override
	public Permission queryById(Integer id) {
		return permissionDao.queryById(id);
	}

	@Override
	public void updatePermission(Permission perm) {
		permissionDao.updatePermission(perm);
		
	}

	@Override
	public void deletePermission(Permission perm) {

		permissionDao.deletePermission(perm);
	}

	@Override
	public List<Integer> queryPermissionsByRoleid(Integer roleid) {

		return permissionDao.queryPermissionsByRoleid(roleid);
	}

	@Override
	public List<Permission> queryPermissionsByUser(User dbUser) {

		return permissionDao.queryPermissionsByUser(dbUser);
	}
	
	
	
}
