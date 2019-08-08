package com.wendao.proj.dao;

import java.util.ArrayList;
import java.util.Date;

import com.wendao.proj.pojo.Emp;

/**
 * 	对db直接操作的接口
 * @author china
 *
 */
public interface EmpDao {
	
	public static int a=1; // 静态属性可以在接口中
	
	public static void add() {
		// 静态方法可以在接口中
	}
	
	// 查询所有员工信息
	public ArrayList<Emp> selAllEmpInfo();
	
	// 根据编号查询员工信息
	public Emp selEmpInfoByEmpno(int empno);
	
	/**
	 *	添加员工信息
	 * @param empno
	 * @param ename
	 * @param sal
	 * @param deptId
	 * @param age
	 * @param bonus
	 * @param birthday
	 * @return the row count for SQL Data Manipulation Language (DML) statements
	 */
	public int insEmpInfo(int empno, String ename, 
			double sal, int deptId, int age, double bonus, Date birthday);
	
	// 修改员工姓名
	public int upEmp(String newName, int empno);
	
	// 删除员工信息
	public int delEmp(int empno);
	
	
	
	
	
}
