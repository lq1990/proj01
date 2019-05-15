/**
 * test
 * 
 * @author china
 *
 */
public class TestPrimitiveDataType {

	public static void main(String[] args) {
		// 测试整形变量
		int a = 15;
		int b = 015; // 八进制
		int c = 0x15; // 16进制
		int d = 0b1101; // 2进制
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		byte age = 30;
		short salary = 30000;
		int population = 2000000000;
		
		long globalPo = 7400000000L; // 整形常量 默认为int类型，需要加L 表示长整型常量
		// 长整型常量赋值非变量 globalPo
		
	}
}
