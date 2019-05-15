package cn.sxt.arrays;

/**
 * test 数组初始化
 * @author china
 *
 */
public class Test02 {
	public static void main(String[] args) {
		 // 静态初始化
		int[] a = {1,2,3,5};
		User[] b = {
					new User(1001, "anna"), 
					new User(1002, "well")
					};
		
		// 默认初始化
		int[] c = new int[3]; // int 默认0， 若boolean 为false， 若对象默认null
		
		// 动态初始化
		int[] a1 = new int[2];
		a1[0] = 1;
		a1[1] = 11;
		
	}
}

