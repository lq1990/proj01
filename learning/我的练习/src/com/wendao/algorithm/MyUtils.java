package com.wendao.algorithm;

import java.util.Arrays;
import java.util.List;

/**
 * utils that defined by myself
 * @author china
 *
 */
public class MyUtils {
	public static void printProducts(List<Item> products) {
		System.out.println("------------------------------");
		System.out.println("products: ");
		for (Item item : products) {
			System.out.println(item.weight+", "+item.value+", "+item.val_per_unit_weigth+", "+item.isUse);
		}
		System.out.println("------------------------------");
		
	}
	
	public static void printBoundList(List<Node> boundList) {
		System.out.println("-----------boundList-------------------");
		System.out.println("boundVal    assistList");
		for (Node n : boundList) {
			
			System.out.println(n.boundVal+"       "+Arrays.toString(n.assistList));
		}
		System.out.println("------------------------------");
	}
}
