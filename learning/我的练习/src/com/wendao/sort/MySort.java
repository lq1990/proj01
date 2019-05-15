package com.wendao.sort;

/**
 * 快速排序的练习，内含递归
 * 
 * @author china
 *
 */
public class MySort {
	public static void main(String[] args) {

		int n = 10;
		Integer[] arr = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Integer(i + (int) (Math.random() * 100));
		}
		showArr(arr);

		System.out.println("########################");

		long t_begin = System.currentTimeMillis();
		quicksort(arr, 0, arr.length - 1);
		long t_end = System.currentTimeMillis();

		showArr(arr);

		System.out.println("\ntime needed: " + (t_end - t_begin) + "ms\n");
		
		int[] arr1 = new int[5];
		for(int item: arr1) {
			System.out.print(item+" ");
		}
		System.out.println();
		fn(arr1);
		for(int item: arr1) {
			System.out.print(item+" ");
		}
		
		
		
	}

	public static void fn(int[] arr) {
		arr[0] = 100;
	}
	
	public static void quicksort(Integer[] arr, int left, int right) {
		int pos;
		if (left < right) {
			pos = findIndex(arr, left, right);
			quicksort(arr, left, pos - 1);
			quicksort(arr, pos + 1, right);
		}

	}

	/**
	 * 
	 * @param left
	 * @param right
	 * @param arr
	 * @return 返回 arr 中最左侧数 应该所处的位置。
	 */
	public static int findIndex(Integer[] arr, int left, int right) {
		int tmp = arr[left];

		while (left < right) {
			while (left < right && arr[right] >= tmp) {
				right--;
			}
			arr[left] = arr[right];

			while (left < right && arr[left] <= tmp) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = tmp;
		return left;
	}

	public static void showArr(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if(i%10==9) {
				System.out.println();
			}
		}
	}
}
