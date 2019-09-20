package com.wendao.test;

public class People {
	private Teacher teacher;
	
	public People() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public People(Teacher teacher222) {
		super();
		this.teacher = teacher222;
	}




	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "People [teacher=" + teacher + "]";
	}
	
	
}
