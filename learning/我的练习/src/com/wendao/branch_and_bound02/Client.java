package com.wendao.branch_and_bound02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 	Problem: Knapsack
 * 	Method: Branch and Bound
 * 
 * 
 * 	1. calculate bound of a node
 * 	2. calculate left and right bound of a node, add them to boundList and remove the old maxBoundValNode
 * 	3. find the node with the max. boundVal in the boundList
 * 	4. loop from 1, until reach the leaf node
 * 
 * 
 * 	Attention:
 * 	1. nullBegin = assistList.length, to avoid mistakes
 * 	2. rm old max after adding left/right child-node
 * 	3. assistList[i] = 1/0/null
 * 
 * @author china
 *
 */
public class Client {
	private static final double MAXWEIGHT = 9;
	private static List<Item> products = new ArrayList<Item>();
	private static List<Node> boundList = new ArrayList<Node>();
	private static Node maxBoundValNode;
	private static double boundVal = 0;
	
	public static void main(String[] args) {
		// 1. products contains items, init this list and sort by val/w
		products.add(new Item(3, 66));
		products.add(new Item(2, 40));
		products.add(new Item(5, 95));
		products.add(new Item(4, 40));
		Collections.sort(products);
		
		// 2. init assistList
		Integer[] assistList = {null, null, null, null}; // each element represents an item, 1/0/null: exist/not exist/unknown
		
//		calcBoundValForAssistList(assistList);
//		System.out.println(boundVal);
		
		// init boundList and maxBoundValNode
		calcLeftRightBoundValAddToBoundList(assistList);
		MyUtils.printBoundList(boundList);
		updateMaxBoundValNode();
		
		while(!isReachLeaf(maxBoundValNode.assistList)) {
			calcLeftRightBoundValAddToBoundList(maxBoundValNode.assistList);
			// rm old max
			boundList.remove(maxBoundValNode);
			updateMaxBoundValNode();
			MyUtils.printBoundList(boundList);
		}
		
	}
	
	/**
	 * next null is 1/0 : left/right
	 * @param assistList
	 */
	public static void calcLeftRightBoundValAddToBoundList(Integer[] assistList) {
		Integer[] assistListLeft = Arrays.copyOf(assistList, assistList.length);
		Integer[] assistListRight = Arrays.copyOf(assistList, assistList.length);
		
		// find nullBegin of assistList
		int nullBegin = findNullBeginOfAssistList(assistListRight);
		if (nullBegin == assistList.length) {
			// now, reach the leaf
			return;
		}
		
		// left
		assistListLeft[nullBegin] = 1;
		boolean isOW = calcBoundValForAssistList(assistListLeft);
		if (!isOW) {
			boundList.add(new Node(boundVal, assistListLeft));
		}
		
		// right
		assistListRight[nullBegin] = 0;
		isOW = calcBoundValForAssistList(assistListRight);
		if (!isOW) {
			boundList.add(new Node(boundVal, assistListRight));
		}
		
	}
	
	/**
	 * 
	 * @param assistList
	 * @return true/false : overweght/not overweight
	 */
	public static boolean calcBoundValForAssistList(Integer[] assistList) {
		// 1. if current assistList is overweight, return true;
		if (isOverWeight(assistList)) {
			return true;
		}
		
		double bound = 0;
//		int nullBegin = assistList.length;
		double cumsumWeight = 0;
		// 2. compute the profit of nodes that are already known in assistList
		for(int i=0; i<assistList.length; i++) {
			if (null == assistList[i]) {
//				nullBegin = i;
				break;
			}
			// not overweight
			int al = assistList[i];
			double val = products.get(i).value;
			cumsumWeight += al * products.get(i).weight;
			bound += al * val;
			
//			System.out.println("bound:"+bound);
		}
		
		// 3. compute the bound of other nodes in assistList
		int nullBegin = findNullBeginOfAssistList(assistList);
		for(int i = nullBegin; i<assistList.length; i++) {
			double w = products.get(i).weight;
			if ((cumsumWeight+w) <= MAXWEIGHT) {
				bound += products.get(i).value;
				cumsumWeight += w;
				
//				System.out.println("cumsumWeight::"+cumsumWeight);
//				System.out.println("bound::"+bound);
			} else {
				// the last one has to be divided
				double restW = MAXWEIGHT - cumsumWeight;
				bound += restW * products.get(i).val_per_unit_w;
//				System.out.println("bound:::"+bound);
				break;
			}
		}
		
		boundVal = bound;
		return false;
	}
	
	public static boolean isOverWeight(Integer[] assistList) {
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

	public static int findNullBeginOfAssistList(Integer[] assistList) {
		int nullBegin = assistList.length; // if assistList doesn't contain null, return 
		for(int i=0; i<assistList.length; i++) {
			if (null == assistList[i]) {
				nullBegin = i;
				break;
			}
		}
		
		return nullBegin;
	}

	public static boolean isReachLeaf(Integer[] assistList) {
		int nullBegin = findNullBeginOfAssistList(assistList);
		if (nullBegin == assistList.length ) {
			return true;
		}
		
		return false;
	}
	
	public static void updateMaxBoundValNode() {
		maxBoundValNode = boundList.get(0);
		for(Node n : boundList) {
			if (n.boundVal > maxBoundValNode.boundVal) {
				maxBoundValNode = n;
			}
		}
	}
	
}

















