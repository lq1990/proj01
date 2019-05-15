/**
 * 
 * @author china
 *
 */
public class TestOverload {
	public static void main(String[] args) {
		System.out.println(add(1,2));
		System.out.println(add(1,2,11));
	}

	public static int add(int n1, int n2) {
		int sum = n1 + n2;
		return sum;
	}

	public static int add(int n1, int n2, int n3) {
		int sum = n1 + n2 + n3;
		return sum;
	}
}
