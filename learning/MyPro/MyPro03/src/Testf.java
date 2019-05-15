/**
 * test if
 * 
 * @author china
 *
 */
public class Testf {
	public static void main(String[] args) {
		double d = Math.random(); // [0,1) 左闭右开
		System.out.println(d);

		// System.out.println((int)(6*Math.random())); // 0,1,2,3,4,5

		int i = (int) (6 * Math.random() + 1);
		System.out.println(i);
		if (i <= 3) {
			System.out.println("小");
		} else {
			System.out.println("大");
		}

		System.out.println("##########");
		double r = 4 * Math.random();
		double area = Math.PI * Math.pow(r, 2);
		double circle = 2 * Math.PI * r;
		System.out.println("半径："+r);
		System.out.println("面积："+area);
		System.out.println("周长："+circle);
		
	}
}
