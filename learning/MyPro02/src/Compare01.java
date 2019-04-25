/**
 * 对比左移运算符，和普通的乘法，速度
 * @author china
 *
 */
public class Compare01 {
	public static void main(String[] args) {
		double num_times = 1e1;
		
		long t_begin = System.currentTimeMillis();
		double res1 = 30;
		for (double i = 0; i < num_times; i++) {
			res1 *= 2;
		}
		System.out.println("res1: "+res1);
		long t_end = System.currentTimeMillis();
		System.out.println("time needed: "+(t_end-t_begin));
		
		
		long t_begin2 = System.currentTimeMillis();
		long res2 = 30;
		for (double i = 0; i < num_times; i++) {
			res2 = res2 << 1; // 左移运算，比普通乘法运算更快。
		}
		System.out.println("res2: "+res2);
		long t_end2 = System.currentTimeMillis();
		System.out.println("time needed: "+(t_end2-t_begin2));

	
		
	}
}
