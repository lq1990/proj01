package com.wendao.pojo;

public class Laozong implements Gongneng {
	private String name;
	
	public Laozong() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Laozong(String name) {
		super();
		this.name = name;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	


	@Override
	public String toString() {
		return "Laozong [name=" + name + "]";
	}



	public void zhidingxiaomubiao() {
		System.out.println("指定小目标");
	}



	@Override
	public void chifan() {
		// TODO Auto-generated method stub
		
		System.out.println("老总吃饭");
		
	}
	
	

}










