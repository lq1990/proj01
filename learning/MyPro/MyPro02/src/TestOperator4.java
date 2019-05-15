/**
 * test 位运算符
 * @author china
 *
 */
public class TestOperator4 {
	public static void main(String[] args) {
		int a = 3; // 0 0 1 1
		int b = 4; // 0 1 0 0
		
		System.out.println(a & b); // 按位与, 0 0 0 0
		System.out.println(a | b); // 按位或，0 1 1 1
		System.out.println(a ^ b); // 按位异或, 0 1 1 1 
		System.out.println(~a);
		
		// 移位运算
		System.out.println("移位运算：");
		System.out.println(a<<1);
		System.out.println(a<<2);
		System.out.println(a>>2);
	}
}
