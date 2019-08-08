package com.wendao.ds.sort;

import java.util.Arrays;

/**
 * quicksort practice
 * @author china
 *
 */
public class QuickSort02 {
	public static void main(String[] args) {
		int[] arr = {10, 3, 5, 99, -4, 73, 5, 72};
		
		System.out.println(Arrays.toString(arr));
		
		// quicksort
		quickSort(arr);
		
		// result
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
	 * @param low lowIndex
	 * @param high highIndex
	 */
	private static void quickSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		
		// find index of midVal
		int midIdx = partition(arr, low, high);
		
		// left
		quickSort(arr, low, midIdx-1);
		
		// right
		quickSort(arr, midIdx+1, high);
	}

	private static int partition(int[] arr, int low, int high) {
		int i = low;
		int j = high;
		
		int midVal = arr[i]; // 挖坑i
		
		while(i < j) {
			while(i < j && arr[j] > midVal) {
				j--;
			}
			
			if (i < j) {
				arr[i] = arr[j]; // 填坑i， 挖坑j
				i++;
			}
			
			while(i < j && arr[i] <= midVal) {
				i++;
			}
			
			if (i < j) {
				arr[j] = arr[i]; // 填坑j，挖坑i
				j--;
			}
			
		}
		// so far, i=j
		
		arr[i] = midVal; // 填坑i，最后的坑被填
		
		return i;
	}
	
	
}























