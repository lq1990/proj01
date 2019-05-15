import java.math.BigDecimal;

/**
 * 
 * @author china
 *
 */
public class TestPrimitiveDataType2 {
	public static void main(String[] args) {
		float a = 3.14F;
		double b = 6.28;
		double c = 628e-2;

		System.out.println("c: " + c);

		// 注：浮点数不精确，不要用于比较。若欲进行比较，请用 BigDecimal
		float f = 0.1f;
		double d = 1.0 / 10;
		System.out.println(f == d);
		// 可用 System.out.println(Math.abs(f-d)<=1e-8);

		BigDecimal f1 = BigDecimal.valueOf(423432423.0);
		BigDecimal f2 = BigDecimal.valueOf(423432423.0+1);
		if (f1 == f2) {
			System.out.println("f1 == f2");
		} else {
			System.out.println("f1 != f2");
		}
		
		System.out.println("##################");
		BigDecimal bd = BigDecimal.valueOf(1.0);
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		System.out.println(bd);
		
		System.out.println(1.0-0.1-0.1-0.1-0.1-0.1); // syso 快捷
		System.out.println("####################");
		
		BigDecimal bd2 = BigDecimal.valueOf(0.1);
		BigDecimal bd3 = BigDecimal.valueOf(1.0/10);
		System.out.println(bd2.equals(bd3));
		

	}
}
