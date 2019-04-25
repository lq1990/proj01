/**
 * 
 * @author china
 *
 */
public class TestTypeConvert {
	public static void main(String[] args) {
		int a = 324;
		long b = a;
		double d = a;
		
		//a = b;
		//long e = 3.23F;
		float f = 3232787L;
		
		// льюЩ
		byte b2 = 123;
		
		char c = 'a';
		System.out.println(c);
		int d1 = c+1;
		System.out.println(d1);
		System.out.println((char)d1);
		
		int m = 1000000000;
		int n = 20;
		long res = 1L*m*n;
		System.out.println(res);
			
		
		
		
	}
}
