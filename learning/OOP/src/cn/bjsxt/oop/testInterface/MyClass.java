package cn.bjsxt.oop.testInterface;

public class MyClass implements MyInterface {

	@Override
	public void test01() {
		System.out.println(MyInterface.MAX_GREAD);
		
		System.out.println("test01");

	}

	@Override
	public int test02(int a, int b) {
		System.out.println("test02");
		return a + b;
	}

}
