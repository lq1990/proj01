package com.wendao.atcrowdfunding.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wendao.atcrowdfunding.bean.AJAXResult;
import com.wendao.atcrowdfunding.bean.Permission;
import com.wendao.atcrowdfunding.service.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionSeriveImpl;

	@ResponseBody
	@RequestMapping("/update")
	public Object update(Permission perm) {
		AJAXResult result = new AJAXResult();

		try {
			permissionSeriveImpl.updatePermission(perm);

			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}

		return result;
	}

	@ResponseBody
	@RequestMapping("/insert")
	public Object insert(Permission perm) {
		AJAXResult result = new AJAXResult();

		try {
			permissionSeriveImpl.insertPermission(perm);

			result.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}

		return result;
	}

	@RequestMapping("/add")
	public String add() {

		return "permission/add";
	}

	@RequestMapping("/edit")
	public String edit(Integer id, Model model) {

		// 拿到修改前的数据
		Permission perm = permissionSeriveImpl.queryById(id);
		model.addAttribute("permission", perm);

		return "permission/edit";
	}

	@RequestMapping("/index")
	public String index() {

		return "permission/index";
	}

	@ResponseBody
	@RequestMapping("/loadData")
	public Object loadData() {

		List<Permission> permissions = new ArrayList<Permission>();

		List<Permission> ps = permissionSeriveImpl.queryAll();

		Map<Integer, Permission> map = new HashMap<Integer, Permission>();
		for (Permission p : ps) {
			map.put(p.getId(), p);
		}

		for (Permission p : ps) {
			Permission child = p;
			if (child.getPid() == 0) {
				// root
				child.setOpen(true);
				permissions.add(child);
			} else {
				Permission parent = map.get(child.getPid()); // 父节点
				parent.getChildren().add(child);
			}
		}

//		Permission root = new Permission();
//		root.setName("顶级节点");
//		root.setOpen(true);
//		
//		Permission child = new Permission();
//		child.setName("子节点1");
//		
//		Permission child2 = new Permission();
//		child2.setName("子节点2");
//		
//		root.getChildren().add(child);
//		root.getChildren().add(child2);
//		
//		permissions.add(root);

		return permissions;
	}

	/**
	 * 递归 1. 自己调自己 2. 有终止条件 3. 调用时，有规律
	 * 
	 * 缺点： 递归效率低
	 * 
	 * @param parent
	 */
	private void queryChildPermissions(Permission parent) {
		List<Permission> childps = permissionSeriveImpl.queryChildPermissions(parent.getId());

		// 终止条件：当childps为null时，for进不去
		for (Permission p : childps) {
			queryChildPermissions(p);
		}

		parent.setChildren(childps);

	}

}
