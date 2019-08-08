package com.wendao.ds.search;

import java.util.Arrays;

/**
 * 前提： 顺序结构 按照关键字排序
 * T(n) = O(log2 n);
 * S(n) = O(1);
 * 
 * @author china
 *
 */
public class TestSearch02BinarySearch {
	public static void main(String[] args) {
		// 给定数组
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//		int[] arr = { 1 };
		System.out.println("scoreArr: " + Arrays.toString(arr));

		// 给定要查找的值
		int key = 10;

		// 二分查找
		int index = binarySearch(arr, key);

		// 输出结果
		if (index == -1) {
			System.out.println(key + "不存在");
		} else {
			System.out.println(key + "的位置：" + index);
		}

	}

	/**
	 * 不用递归
	 * 
	 * @param arr
	 * @param key
	 * @return
	 */
	private static int binarySearch(int[] arr, int key) {
		// low high
		int low = 0;
		int high = arr.length - 1;


		// 折半
		while (low <= high) {
			System.out.println("low: "+low+", high: "+high);
			
			// mid
			int mid = (low + high) / 2;
			// if equal
			if (key == arr[mid]) {
				return mid;
			} else if (key < arr[mid]) {
				high = mid - 1;
			} else {
				// key > arr[mid]
				low = mid + 1;
			}
		}

		return -1;
	}
	
	
	
}












