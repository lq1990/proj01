import java.util.Scanner;

/**
 * 
 * @author china
 *
 */
public class TestScanner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("pls input name:");
		String name = scanner.nextLine();
		
		System.out.println("pls input hobby:");
		String favor = scanner.nextLine();
		
		System.out.println("pls input age:");
		int age = scanner.nextInt();
		
		System.out.println("#############");
		System.out.println(name);
		System.out.println(favor);
		System.out.println(age);
		
	}
}
