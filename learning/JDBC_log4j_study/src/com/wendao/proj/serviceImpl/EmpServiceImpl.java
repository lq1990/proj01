package com.wendao.proj.serviceImpl;

import java.util.Scanner;

import com.wendao.proj.daoImpl.EmpDaoImpl;
import com.wendao.proj.pojo.Emp;

/**
 * 	业务层。
 * 	被main调用。
 * 	
 * 	业务层调用db层。
 * @author china
 *
 */
public class EmpServiceImpl {
	public void update() {
		// get user data
		Scanner sc = new Scanner(System.in);
		System.out.println("pls input empno: ");
		int empno = sc.nextInt();
		System.out.println("empnp: "+empno);
		
		System.out.println("pls input new name: ");
		String newName = sc.next();
		
		// 数据库层 对象调用
		EmpDaoImpl ed = new EmpDaoImpl();
		Emp info = ed.selEmpInfoByEmpno(empno);
		
		int res = ed.upEmp(newName, empno);
		System.out.println("res: "+res);
		
		if (res > 0) {
			System.out.println("already done.");
			System.out.println("old ename: "+ info.getEname());
			System.out.println("new ename: "+ newName);
		} else {
			System.out.println("failed to update");
		}
	}
	
	public void ins() {
		
	}
}
