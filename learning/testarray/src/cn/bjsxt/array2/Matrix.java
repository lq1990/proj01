package cn.bjsxt.array2;

/**
 * test Matrix +
 * 
 * @author china
 *
 */
public class Matrix {
	public static void main(String[] args) {
		int[][] a = { { 1, 3, 4 }, { 2, 4, 8 }, {2,3,4} };
		int[][] b = { { 1, 31, 4 }, { 21, 4, 8 }, {2,3,41} };

		int[][] c = add(a, b);

		show(a);
		System.out.println("\t+");
		show(b);
		System.out.println("\t=");
		show(c);

	}

	public static int[][] add(int[][] a, int[][] b) {
		int[][] c = new int[a.length][a[0].length];

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}

		return c;
	}

	public static void show(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
