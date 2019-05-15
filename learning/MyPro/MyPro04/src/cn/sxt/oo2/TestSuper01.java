package cn.sxt.oo2;

public class TestSuper01 {
	public static void main(String[] args) {
		new ChildClass().f();
	}
}

class FatherClass {
	public int value;
	public void f() {
		value = 100;
		System.out.println("FatherClass.vlaue = "+this.value); // 100
	} 
}

class ChildClass extends FatherClass {
	public int value;
	
	public void f() {
		super.f();
		this.value = 200;
		System.out.println("ChildClass.value="+this.value); // 200
		System.out.println(value); // 200
		System.out.println(super.value); // 100
	}
}
