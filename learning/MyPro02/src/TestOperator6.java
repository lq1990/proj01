/**
 * 
 * @author china
 *
 */
public class TestOperator6 {
	public static void main(String[] args) {
		int score = 80;
		String type = score<60 ? "不及格" : "及格";
		System.out.println(type);
		
		
		System.out.println(true & true);
		System.out.println(true & false);
		System.out.println(false & true);
		System.out.println(false & false);
		
		System.out.println(false && 1<1/0); // && 为短路，可作为逻辑与 使用
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		
		System.out.println(true | true);
		System.out.println(false | false);
		System.out.println(true | false);
		System.out.println(false | true);
		
		System.out.println(true || true); // || 短路或，可作为逻辑或 使用
		System.out.println(false || false);
		System.out.println(true || false);
		System.out.println(false || true);
	}
}
