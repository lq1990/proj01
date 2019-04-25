/**
 * 
 * @author china
 *
 */
public class TestRecursion01 {
	public static void main(String[] args) {
		a();
	}

	static int count = 0;
	static void a() {
		System.out.println("fn a");
		
		count++;
		if (count<10) {
			a();
		} else {
			return;
		}
	}

	static void b() {
		System.out.println("fn b");
	}
	
	
}
