package com.wendao.atcrowdfunding.service;

import java.util.List;
import java.util.Map;

import com.wendao.atcrowdfunding.bean.Role;

public interface RoleService {

	public List<Role> queryAll();

	public List<Role> pageQuery(Map<String, Object> map);

	public int pageQueryCount(Map<String, Object> map);

	public void insertRole(Role role);

	public Role queryById(Integer id);

	public void updateRole(Role role);

	public void deleteRoleById(Integer id);

	public void deleteRoles(Map<String, Object> map);

	public void insertRolePermission(Map<String, Object> paramMap);
	
}
