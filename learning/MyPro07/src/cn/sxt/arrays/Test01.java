package cn.sxt.arrays;

import java.util.Iterator;

public class Test01 {

	public static void main(String[] args) {
		int[] arr01 = new int[10];
		String[] arr02 = new String[5];

		arr01[0] = 13;
		arr01[1] = 15;
		arr01[2] = 2;

		// loop init
		for (int i = 0; i < arr01.length; i++) {
			arr01[i] = 10 * i;
		}
		
		// loop read
		/*
		for (int i = 0; i < arr01.length; i++) {
			System.out.println(arr01[i]);
		}
		*/

//		User[] arr03 = new User[3]; // 其实：把类的地址信息 放到了数组
//		arr03[0] = new User(1001, "anna");
//		arr03[1] = new User(1002, "beta");
//		arr03[2] = new User(1003, "cello");
//		
//		for(int i=0;i<arr03.length;i++) {
//			System.out.println(arr03[i].getName());
//		}
		
		System.out.println("################");
		// foreach循环：用于读取数组元素，不能修改
		for(int m : arr01) {
			System.out.println(m);
		}
		
		
	}
}
