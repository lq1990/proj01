package cn.bjsxt.array2;

/**
 * test 多维数组
 * 
 * @author china
 *
 */
public class Test01 {
	public static void main(String[] args) {
		// 静态初始化
		int[][] a = { // 数组元素还是数组
				{ 1, 2 }, { 3, 4, 0, 9 }, { 5, 6, 7 } };
		
		// 动态初始化
		int[][] a2 = new int[3][];
		a2[0]= new int[2];
		a2[1]= new int[4];
		a2[2]= new int[3];
		a2[0][0] = 1;
		a2[0][1] = 2;
		a2[1][0] = 3;
		a2[1][1] = 4;
		a2[1][2] = 0;
		a2[1][3] = 9;
		a2[2][0] = 5;
		a2[2][1] = 6;
		a2[2][2] = 7;
		
		System.out.println(a2[2][1]);
		System.out.println(a2.length);
		
		int[][] a3 = new int[3][2];
		a3[0][0] = 11;
		System.out.println(a3[0][0]);
		
	}
}
