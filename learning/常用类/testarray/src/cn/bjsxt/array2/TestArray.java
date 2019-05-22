package cn.bjsxt.array2;

import java.util.Arrays;

/**
 * test array fn
 * 
 * @author china
 *
 */
public class TestArray {

	public static void main(String[] args) {
		int[] a = {1,2,323,23,543, 12, 59};
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		
		System.out.println(Arrays.binarySearch(a, 12));
		
		System.out.println("############");
		for(int item : a) {
			System.out.print(item+" ");
		}
	}
	
	public static void show(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
