package cn.sxt.oo2;

public class TestSuper02 {
	public static void main(String[] args) {
		System.out.println("create a ChildClass obj");
		new ChildClass2();
	}
}

class FatherClass2 {
	public FatherClass2() {
		super();
		System.out.println("create FatherClass");
	}
}

class ChildClass2 extends FatherClass2 {
	public ChildClass2() {
		super(); // 即使人为不写，也默认有。
		System.out.println("create ChildClass");
	}
}

// 继承树追溯，Child -> Father -> Object。
// 在构造Child时，会先调用Object初始化，再Father，再 Child
