package com.wendao.atcrowdfunding.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.wendao.atcrowdfunding.bean.Role;

public interface RoleDao {

	@Select("select * from t_role")
	List<Role> queryAll();

	List<Role> pageQuery(Map<String, Object> map);

	int pageQueryCount(Map<String, Object> map);

	
	void insertRole(Role role);

	@Select("select * from t_role where id=#{id}")
	Role queryById(Integer id);

	
	void updateRole(Role role);

	
	void deleteRoleById(Integer id);

	void deleteRoles(Map<String, Object> map);

	
	void insertRolePermission(Map<String, Object> paramMap);

	void deleteRolePermissions(Map<String, Object> paramMap);
	
	
}
