/**
 * 
 * @author china
 *
 */
public class TestMethod {
	public static void main(String[] args) {
		// 通过对象调用普通方法
		TestMethod tm = new TestMethod();
		tm.printSxt();
		tm.printSxt();
		tm.printSxt();
		int c = tm.add(1, 2, 3) + 1000;
		System.out.println(c);
	}
	
	// 定义的 普通方法
	void printSxt() {
		System.out.println("啦啦啦啦啦");
	}
	
	int add(int a, int b, int c) {
		int sum = a+b+c;
		System.out.println(sum);
		return sum; // return 会结束方法的运行，并返回值
	}
}
