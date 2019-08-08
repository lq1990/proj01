package com.wendao.ds.sort;

import java.util.Arrays;

/**
 * 
 * @author china
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		// 给出无序数组
		int arr[] = {72, 6, 57, 88, 60, 42, 83,72, 72, 48, 85};
		
		// 输出无序数组
		System.out.println(Arrays.toString(arr));
		
		// 快速排序
		quickSort(arr);
		
		// 输出
		System.out.println(Arrays.toString(arr));
		
		
	}

	public static void quickSort(int[] arr) {
		int low = 0;
		int high = arr.length-1;
		quickSort(arr, low, high);
		
	}

	/**
	 * recursive
	 * @param arr
	 * @param low
	 * @param high
	 */
	private static void quickSort(int[] arr, int low, int high) {
		// 终止条件
		if (low>=high) {
			return;
		}
		System.out.println("low: "+low+", high: "+high);
		
		// 分区操作。如何知道以哪个位置分开的呢？ 找到基准数的位置
		int index = partition(arr, low, high);
		
		// 对左分区 进行快排
		quickSort(arr, low, index-1);
		
		// 对右分区 进行快排
		quickSort(arr, index+1, high);
		
	}

	/**
	 * 
	 * @param arr
	 * @param low lowIndex
	 * @param high highIndex
	 * @return
	 */
	private static int partition(int[] arr, int low, int high) {
		// 指定左指针i 和 右指针j
		int i = low;
		int j = high;
		
		// 指定基准值，挖坑i
		int midVal = arr[i]; // arr[low]
		
		// 使用循环实现分区操作
		while(i<j) {
			// 从右到左移动j
			while(i < j && arr[j] > midVal) {
				j--;
			}
			
			if (i<j) {
				arr[i] = arr[j]; // 填坑i，挖坑j
				i++;
			}
			
			// 从左到右
			while(i < j && arr[i] <= midVal) {
				i++;
			}
			
			if (i<j) {
				arr[j] = arr[i]; // 填坑j，挖坑i
				j--;
			}
			
		}
		
		// 使用基准值填坑，这就是基准值的最终位置
		arr[i] = midVal; // i=j。基准值填最后的坑
		
		// 返回 index
		return i;
	}
	
	
	
}











