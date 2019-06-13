package com.wendao.branch_and_bound03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Branch and Bound
 * 		solve Knapsack
 * 
 * why save time:
 * 1. greedy. select the node with max boundVal in list
 * 2. if overweight, not add into list 
 * 
 * @author china
 *
 */
public class Client {
	private static final double MAXWEIGHT = 13;
	private static List<Node> boundNodeList;
	private static List<Item> products;
	private static Node maxBoundValNode;
	private static double boundVal;
	
	static {
		boundNodeList = new ArrayList<Node>();
		products = new ArrayList<Item>();
	}
	
	public static void main(String[] args) {
		double tBegin = System.currentTimeMillis();
		// 1. init products
		products.add(new Item(3, 66));
		products.add(new Item(3, 66));
		products.add(new Item(2, 40));
		products.add(new Item(2, 40));
		products.add(new Item(5, 95));
		products.add(new Item(4, 40));
		Collections.sort(products);
		MyUtils.printList(products);
		
		// init 
		Integer[] initAssistList = new Integer[products.size()];
		maxBoundValNode = new Node(0, initAssistList);
		boundNodeList.add(maxBoundValNode);
		
		while(!isReachLeaf(maxBoundValNode.assistList)) {
			calcLeftRightBoundAddToList(maxBoundValNode.assistList);
			updateMaxBoundValNode();
			MyUtils.printList(boundNodeList);
		}
	
		System.out.println("best: "+ maxBoundValNode.boundVal+", "+ Arrays.toString(maxBoundValNode.assistList));
		System.out.println("time needed: "+(System.currentTimeMillis() - tBegin)+"ms");
		
	}
	
	private static boolean isReachLeaf(Integer[] assistList) {
		int nullBegin = findNullBegin(assistList);
		if (nullBegin == assistList.length) {
			return true;
		}
		return false;
	}
	
	private static void updateMaxBoundValNode() {
		// Attention: find from the first one
		Node maxNode = boundNodeList.get(0);
		for(Node n : boundNodeList) {
			if (n.boundVal > maxNode.boundVal) {
				maxNode = n;
			}
		}
		
		maxBoundValNode = maxNode;
	}
	
	private static void calcLeftRightBoundAddToList(Integer[] assistList) {
		int nullBegin = findNullBegin(assistList);
		if (nullBegin == assistList.length) {
			return;
		}
		
		Integer[] assistListLeft = Arrays.copyOf(assistList, assistList.length);
		Integer[] assistListRight = Arrays.copyOf(assistList, assistList.length);
		
		assistListLeft[nullBegin]=1;
		boolean isOW = calcBoundValForAssistList(assistListLeft);
		if (!isOW) {
			boundNodeList.add(new Node(boundVal, assistListLeft));
		}
		
		assistListRight[nullBegin]=0;
		isOW = calcBoundValForAssistList(assistListRight);
		if (!isOW) {
			boundNodeList.add(new Node(boundVal, assistListRight));
		}
		
		boundNodeList.remove(maxBoundValNode);
		
//		System.out.println("max: "+maxBoundValNode.boundVal+", "+Arrays.toString(maxBoundValNode.assistList));
	}
	
	
	/**
	 * 
	 * @param assistList
	 * @return true/false : overWeight/ not overweight 
	 */
	private static boolean calcBoundValForAssistList(Integer[] assistList) {
		if (isOverWeight(assistList)) {
			return true;
		}
		// else not overweight
		double profit = 0;
		double cumsumWeight = 0;
		int nullBegin = findNullBegin(assistList);
		// already confirmed, so called profit
		for(int i=0; i< nullBegin; i++) {
			Integer al = assistList[i]; // al = 1/0/null
			profit += al * products.get(i).value;
			cumsumWeight += al * products.get(i).weight;
		}
		
		double bound = profit;
		
		// not yet determined
		for(int i=nullBegin; i<assistList.length; i++) {
			double w = products.get(i).weight;
			if ((cumsumWeight+w) <= MAXWEIGHT) {
				bound += products.get(i).value;
				cumsumWeight += w;
			} else {
				bound += products.get(i).val_per_unit_w * (MAXWEIGHT - cumsumWeight);		
				break;
			}
		}
		
		boundVal = bound;
		return false;
	}
	
	private static boolean isOverWeight(Integer[] assistList) {
		double wSum = 0;
		for(int i=0; i<assistList.length; i++) {
			Integer al = assistList[i];
			if (null == al) {
				break;
			}
			double w = products.get(i).weight;
			wSum += al * w;
		}
		
		if (wSum > MAXWEIGHT) {
			System.out.println("\t\t\toverweight: "+Arrays.toString(assistList));
			return true;
		}
		
		return false;
	}
	
	private static int findNullBegin(Integer[] assistList) {
		int nullBegin = assistList.length;
		for(int i=0; i<assistList.length; i++) {
			if (null == assistList[i]) {
				nullBegin = i;
				break;
			}
		}
		
		return nullBegin;
	}
	
}














