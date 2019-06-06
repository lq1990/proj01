package com.wendao.branch_and_bound02;

import java.util.Arrays;
import java.util.List;

public class MyUtils {
	public static void printProducts(List<Item> products) {
		System.out.println("------ products ------");
		for (Item item : products) {
			System.out.println(item.weight+"\t"+item.value+"\t"+item.val_per_unit_w);
		}
		System.out.println("------------------------");
	}
	
	public static void printBoundList(List<Node> boundList) {
		System.out.println("------ boundList ----------");
		for (Node node : boundList) {
			System.out.println(node.boundVal+", " + Arrays.toString(node.assistList));
		}
		System.out.println("---------------------------");
	}
}
