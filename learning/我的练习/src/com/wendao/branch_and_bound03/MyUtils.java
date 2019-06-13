package com.wendao.branch_and_bound03;

import java.util.Arrays;
import java.util.List;

public class MyUtils {
	public static <T> void printList(List<T> alist) {
		System.out.println("-------------------");
		for (T t : alist) {
			if (t instanceof Item) {
				System.out.println( "Item: "+((Item) t).weight + ", "+ ((Item) t).value +", " + ((Item) t).val_per_unit_w);
			} else if (t instanceof Node) {
				System.out.println( "Node: "+((Node) t).boundVal + ", "+ Arrays.toString(((Node) t).assistList));
			}
		}
		System.out.println("-------------------");
	}
}
