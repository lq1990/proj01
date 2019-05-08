package com.wendaochupin.sort;

import java.util.Arrays;

/**
 * 
 * @author china
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] values = { 3, 1, 6, 2, 9, 0, 7, 4, 5, 8 };
		System.out.println(Arrays.toString(values));
		
		sort(values);
		System.out.println(Arrays.toString(values));

	}

	/**
	 * 从小到大排序
	 * 
	 * @param values
	 */
	public static void sort(int[] values) {
		int temp;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length - 1 - i; j++) {
				if(values[j] > values[j+1]) {
					temp = values[j];
					values[j] = values[j+1];
					values[j+1] = temp;
				}
			}
		}
	}
}
