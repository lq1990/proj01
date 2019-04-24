/**
 * test var
 * 
 * @author china
 *
 */
public class TestVariable {
	static int size; // 静态变量，从属于 类
	
	boolean a; // 成员变量, 从属于对象
	
	public static void main(String[] args) {
		{
			int age; // local var，从属于语句块
		}
		int salary = 3000; // local var 从属于方法
		
		int gao = 10;
		System.out.println(gao);
		
		TestVariable tv = new TestVariable();
		System.out.println(tv.a);
	}
}
