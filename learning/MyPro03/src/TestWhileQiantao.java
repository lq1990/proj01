/**
 * 
 * 
 * @author china
 *
 */
public class TestWhileQiantao {
	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
		System.out.println("###############");

		// 1*2=2 2*2=4
		for (int r = 1; r <= 9; r++) {
			for (int c = 1; c <= r; c++) {
				System.out.print("" + c + "*" + r + "=" + (r * c) + "\t");
			}
			System.out.println();
		}

		System.out.println("###################");
		// 100以内的奇数、偶数的和
		int sum_odd = 0;
		int sum_even = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 0) {
				sum_even += i;
			} else {
				sum_odd += i;
			}
		}
		System.out.println("100以内奇数和：" + sum_odd);
		System.out.println("100以内偶数和：" + sum_even);

		System.out.println("##############");
		// 输出1到1000之间，被5整除的数，每行输出5个
		int count = 0;
		for (int i = 1; i <= 1000; i++) {

//			if (i % 5 == 0) {
//				System.out.print(i+"\t");
//				if(i%25==0) {
//					System.out.println();
//				}
//			}
			if(i%5==0) {
				count++;
				System.out.print(i+"\t");
				if(count%5==0) {
					System.out.println();
				}
			}

		}
	}

}
