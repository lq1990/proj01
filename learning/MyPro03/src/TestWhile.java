/**
 * 
 * @author china
 *
 */
public class TestWhile {
	public static void main(String[] args) {
		// calc 1+2+3+...+100
		int i=0;
		int sum = 0;
		while(i<=100) {
			sum += i;
			i++;
		}
		System.out.println(sum);
	}
}
