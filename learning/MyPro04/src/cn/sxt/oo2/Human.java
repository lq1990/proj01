package cn.sxt.oo2;

public class Human {
	private int age;
	String name; // default 访问控制符，本包中类可以访问
	
	protected int height;
	
	public void sayAge() {
		System.out.println(age);
	}
}
