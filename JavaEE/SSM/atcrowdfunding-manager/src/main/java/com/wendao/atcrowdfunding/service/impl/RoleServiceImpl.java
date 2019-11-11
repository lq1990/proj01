package com.wendao.atcrowdfunding.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wendao.atcrowdfunding.bean.Role;
import com.wendao.atcrowdfunding.dao.RoleDao;
import com.wendao.atcrowdfunding.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	/**
	 * 	使用Autowired 自动装配
	 */
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> queryAll() {
		return roleDao.queryAll();
	}

	@Override
	public List<Role> pageQuery(Map<String, Object> map) {
		
		return roleDao.pageQuery(map);
	}

	@Override
	public int pageQueryCount(Map<String, Object> map) {
		
		return roleDao.pageQueryCount(map);
	}

	@Override
	public void insertRole(Role role) {

		roleDao.insertRole(role);
	}

	@Override
	public Role queryById(Integer id) {

		return roleDao.queryById(id);
	}

	@Override
	public void updateRole(Role role) {
		
		roleDao.updateRole(role);
	}

	@Override
	public void deleteRoleById(Integer id) {
		roleDao.deleteRoleById(id);
		
	}

	@Override
	public void deleteRoles(Map<String, Object> map) {

		roleDao.deleteRoles(map);
	}
	
	
	
}



