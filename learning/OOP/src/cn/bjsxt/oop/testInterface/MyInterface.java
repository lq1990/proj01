package cn.bjsxt.oop.testInterface;

/**
 * 接口在编译时，也会变成 class
 * @author china
 *
 */
public interface MyInterface {
	// 接口中只有：常量、抽象方法
	/*默认附带 public static final*/ String MAX_GREAD = "BOSS";
	int MAX_SPEED = 120;
	
	/*默认附带 public abstract*/ void test01();
	public int test02(int a, int b);
}
