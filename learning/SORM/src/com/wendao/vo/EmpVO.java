package com.wendao.vo;

/**
 * 	把sql语句中用到的参数，再封装
 * @author china
 *
 */
public class EmpVO {
//	select e.id,e.empname,salary+bonus 'income',
//		e.age,d.dname 'deptName',d.address 'deptAddress' 
//	from emp e join dept d on e.deptId=d.id;
	
	private Integer id;
	private String empname;
	private Double income;
	private Integer age;
	private String deptName;
	private String deptAddr;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptAddr() {
		return deptAddr;
	}
	public void setDeptAddr(String deptAddr) {
		this.deptAddr = deptAddr;
	}
	
	public EmpVO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param empname
	 * @param income
	 * @param age
	 * @param deptName
	 * @param deptAddr
	 */
	public EmpVO(Integer id, String empname, Double income, Integer age, String deptName, String deptAddr) {
		super();
		this.id = id;
		this.empname = empname;
		this.income = income;
		this.age = age;
		this.deptName = deptName;
		this.deptAddr = deptAddr;
	}
	
	
	
}
