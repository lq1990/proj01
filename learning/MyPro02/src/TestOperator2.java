/**
 * 
 * @author china
 *
 */
public class TestOperator2 {
	public static void main(String[] args) {
		char b = 'a';
		char b2 = 'c';
		System.out.println((int) b);
		System.out.println(0 + b); // 相加时，char会默认转为 int
		System.out.println(0 + b2); // 相加时，char会默认转为 int
		System.out.println(b < b2);
	}
}
