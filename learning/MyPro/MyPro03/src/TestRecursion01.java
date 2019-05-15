/**
 * 
 * @author china
 *
 */
public class TestRecursion01 {
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		System.out.println(t1);
		System.out.println(factorial(100));
		
		long t2 = System.currentTimeMillis();
		System.out.println(t2);
		
		System.out.printf("time needed: %s%n",(t2-t1));
		
	}
	
	public static double factorial(int n) {
		if (n==1) {
			return 1D; // double 1
		} else {
			return 1D*n*factorial(n-1);
		}
	}
	
	
}
