package com.wendao.branch_and_bound04;

import java.util.Arrays;
import java.util.List;

public class MyUtils {
	public static <T> void printList(List<T> alist) {
		System.out.println("---------------------");
		for(T t : alist) {
			if (t instanceof Node) {
				System.out.println(((Node)t).boundVal+", "+ Arrays.toString(((Node)t).assistList));
			} else if (t instanceof Item) {
				System.out.println(((Item)t).value+", "+ ((Item)t).weight+", "+((Item)t).val_per_unit_w);
			}
		}
		System.out.println("---------------------");
	}
}
