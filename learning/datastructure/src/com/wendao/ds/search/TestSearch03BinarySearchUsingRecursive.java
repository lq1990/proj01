package com.wendao.ds.search;

import java.util.Arrays;

/**
 * 前提： 顺序结构 按照关键字排序
 * 
 * @author china
 *
 */
public class TestSearch03BinarySearchUsingRecursive {
	public static void main(String[] args) {
		// 给定数组
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//		int[] arr = { 1 };
		System.out.println("scoreArr: " + Arrays.toString(arr));

		// 给定要查找的值
		int key = 6;

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
	 * 用递归
	 * T(n) = O(log2 n);
	 * S(n) = O(log2 n);
	 * 
	 * @param arr
	 * @param key
	 * @return
	 */
	private static int binarySearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length-1;
		
		return binarySearch(arr, key, low, high);
		
		
	}
	
	private static int binarySearch(int[] arr, int key, int low, int high) {
		// 结束条件
		if (low > high) {
			return -1;
		}
		
		int mid = (low + high)/2;
		
		if (key==arr[mid]) {
			return mid;
		} else if (key < arr[mid]) {
			return binarySearch(arr, key, low, mid-1);
		} else {
			return binarySearch(arr, key, mid+1, high);
		}
		
	}
	
}












