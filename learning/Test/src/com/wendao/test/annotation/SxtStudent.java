package com.wendao.test.annotation;

@SxtTable(value = "tb_student")
public class SxtStudent {

	@SxtField(columnName = "id", length = 10, type = "int")
	private int id;

	@SxtField(columnName = "sname", length = 10, type = "varchar")
	private String stuName;

	@SxtField(columnName = "age", length = 3, type = "int")
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
