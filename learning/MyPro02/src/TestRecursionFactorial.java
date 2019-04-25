import javax.swing.plaf.SliderUI;

/**
 * 
 * @author china
 *
 */
public class TestRecursionFactorial {
	public static void main(String[] args) {
		long d1 = System.currentTimeMillis();
		
		double num = 40;
		double res = factorial(num);
		System.out.printf("%d阶乘的结果：%s%n",(int)num,res);
		
		long d2 = System.currentTimeMillis();
		System.out.printf("递归耗时：%s ms%n",d2-d1);
		
		factorialLoop(num);
	}

	/**
	 * 
	 * @param n
	 * @return
	 */
	static double factorial(double n) {
		if (n==1) {
			return 1;
		} else {
			return n*factorial(n-1);
		}
	}
	
	static double factorialLoop(double a) {
		long t_begin = System.currentTimeMillis();
		
		double res = 1;
		while (a>1) {
			res *= a*(a-1);
			a -= 2;
		}
		System.out.println("res: "+res);
		
		
		long t_end = System.currentTimeMillis();
		System.out.printf("for loop, time needed: %s ms",t_end-t_begin);
		
		return res;
	}

}
