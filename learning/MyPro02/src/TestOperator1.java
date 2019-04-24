/**
 * 
 * @author china
 *
 */
public class TestOperator1 {

	public static void main(String[] args) {
		/*
		byte a = 1;
		int b = 2;
		long b2 = 3;
		// byte c = a+b; // 错
		// int c2 = b2 + b; // 错
		float f1 = 3.14F;
		float d = b + b2; // float 表示范围更大，所以对

		float d2 = f1 + 6.2F;

		System.out.println(9 % 5);
		System.out.println(-9 % 5);
		System.out.println(-9 % -5);
		System.out.println(9 % -5);
		 */
		
		int a = 3;
		int b = a++;
		System.out.println("a: "+a+"\nb: "+b);
		
		int aa = 3;
		int bb = ++aa;
		System.out.println("aa: "+aa+"\nbb: "+bb);
		

	}
}
