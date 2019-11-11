package com.wendao.atcrowdfunding.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wendao.atcrowdfunding.bean.Permission;

public interface PermissionDao {

	@Select("select * from t_permission where pid=0")
	Permission queryRootPermission();

	@Select("select * from t_permission")
	List<Permission> queryAll();

	@Select("select * from t_permission where pid=#{pid}")
	List<Permission> queryChildPermissions(Integer pid);

	
	void insertPermission(Permission perm);

	@Select("select * from t_permission where id=#{id}")
	Permission queryById(Integer id);

	
	void updatePermission(Permission perm);

}
