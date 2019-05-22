package cm.bjsxt.test;

/**
 * 测试自动装箱、拆箱
 * 
 * @author china
 *
 */
public class TestBoxing {
	public static void main(String[] args) {
		Integer a = new Integer(1001);
		Integer a2 = 1000; // auto-boxing
		
		Integer b = 12;
		System.out.println(b);
		
		int c = b; // int c = b.intValue()
		System.out.println(c);
		
		Integer d = 1234;
		Integer d2 = 1234;
		System.out.println(d==d2); // false
		System.out.println(d.equals(d2)); // true
		
		System.out.println("###########");
		Integer d3 = 12; // [-128, 127] 之间的数，依然当做 基本数据类型处理
		Integer d4 = 12;
		System.out.println(d3==d4);
		System.out.println(d3.equals(d4));
	}
}
