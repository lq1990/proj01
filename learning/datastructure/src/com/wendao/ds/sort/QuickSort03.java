package com.wendao.ds.sort;

import java.util.Arrays;

public class QuickSort03 {
	public static void main(String[] args) {
		int[] arr = { 11, 33, 21, -4, 98, 72, 72 };
		System.out.println(Arrays.toString(arr));

		quickSort(arr);

		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr) {
		int low = 0;
		int high = arr.length - 1;

		quickSort(arr, low, high);
	}

	/**
	 * recursive
	 * 
	 * @param arr
	 * @param low  lowIndex
	 * @param high highIndex
	 */
	private static void quickSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}

		int midIndex = partition(arr, low, high);

		// left
		quickSort(arr, low, midIndex - 1);

		// right
		quickSort(arr, midIndex + 1, high);

	}

	/**
	 * find midIndex
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partition(int[] arr, int low, int high) {
		int i = low;
		int j = high;

		int midVal = arr[i]; // 挖坑i

		while (i < j) {
			// from right to left
			while (i < j && arr[j] > midVal) {
				j--;
			}

			if (i < j) {
				// 填坑i，挖坑j
				arr[i] = arr[j];
				i++;
			}

			// from left to right
			while (i < j && arr[i] <= midVal) {
				i++;
			}

			if (i < j) {
				// 填坑j，挖坑i
				arr[j] = arr[i];
				j--;
			}

		}

		arr[i] = midVal;
		return i;
	}

}
