package com.wendao.branch_and_bound04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Knapsack
 * 
 * 
 * @author china
 *
 */
public class Client {
	private static final double MAXWEIGHT = 12;
	private static List<Node> boundNodeList;
	private static List<Item> products;
	private static Node maxBoundValNode;
	private static double boundVal;

	static {
		boundNodeList = new ArrayList<Node>();
		products = new ArrayList<Item>();
	}

	public static void main(String[] args) {
		// init products
		products.add(new Item(3, 66));
		products.add(new Item(3, 66));
		products.add(new Item(2, 40));
		products.add(new Item(5, 95));
		products.add(new Item(4, 40));
		Collections.sort(products);
		MyUtils.printList(products);
		
		// init maxBoundValNode and boundNodeList
		maxBoundValNode = new Node(0, new Integer[products.size()]);
		boundNodeList.add(maxBoundValNode);

		// loop util reaches the leaf
		int loop = 0;
		while (!isReachLeaf(maxBoundValNode.assistList)) {
			System.out.println("loop: "+(++loop));
			calcLeftRightBoundAddToList(maxBoundValNode);
			updateMaxBoundValNode();
			MyUtils.printList(boundNodeList);
		}
		
		System.out.println("best: "+ maxBoundValNode.boundVal + ", "+ Arrays.toString(maxBoundValNode.assistList));
		

	}
	
	private static void updateMaxBoundValNode() {
		Node maxNode = boundNodeList.get(0);
		for(Node n : boundNodeList) {
			if (n.boundVal > maxNode.boundVal) {
				maxNode = n;
			}
		}
		
		maxBoundValNode = maxNode;
	}

	private static void calcLeftRightBoundAddToList(Node maxNode) {
		Integer[] assistList = maxNode.assistList;
		
		if (isReachLeaf(assistList)) {
			return;
		}
		
		int nullBegin = findNullBegin(assistList);
		
		Integer[] assistListLeft = Arrays.copyOf(assistList, assistList.length);
		Integer[] assistListRight = Arrays.copyOf(assistList, assistList.length);
		
		// left
		assistListLeft[nullBegin] = 1;
		boolean isOW = calcBoundForAssistList(assistListLeft);
		if(!isOW) {
			boundNodeList.add(new Node(boundVal, assistListLeft));
		}
		
		// right
		assistListRight[nullBegin] = 0;
		isOW = calcBoundForAssistList(assistListRight);
		if(!isOW) {
			boundNodeList.add(new Node(boundVal, assistListRight));
		}
		
		// remove old max
		boundNodeList.remove(maxBoundValNode);
		
	}

	private static boolean calcBoundForAssistList(Integer[] assistList) {
		if (isOverweight(assistList)) {
			return true;
		}

		double profit = 0;
		double bound = 0;
		double cumsumW = 0;
		int nullBegin = findNullBegin(assistList);

		// profit
		for (int i = 0; i < nullBegin; i++) {
			Integer al = assistList[i];
			cumsumW += al * products.get(i).weight;
			profit += al * products.get(i).value;
		}

		bound = profit;

		// bound
		for (int i = nullBegin; i < assistList.length; i++) {
			double w = products.get(i).weight;
			if (cumsumW + w <= MAXWEIGHT) {
				bound += products.get(i).value;
				cumsumW += w;
			} else {
				bound += products.get(i).val_per_unit_w * (MAXWEIGHT - cumsumW);
				break;
			}
		}

		boundVal = bound;
		return false;
	}

	private static boolean isOverweight(Integer[] assistList) {
		double wSum = 0;
		for (int i = 0; i < assistList.length; i++) {
			Integer al = assistList[i];
			if (null == al) {
				break;
			}

			wSum += al * products.get(i).weight;
		}

		if (wSum > MAXWEIGHT) {
			System.out.println("\t\t\toverweight: "+Arrays.toString(assistList));
			return true;
		}
		return false;
	}

	private static int findNullBegin(Integer[] assistList) {
		int nullBegin = assistList.length;
		for (int i = 0; i < assistList.length; i++) {
			if (null == assistList[i]) {
				nullBegin = i;
				break;
			}
		}

		return nullBegin;
	}

	/**
	 * isReachLeaf means: assistList [x,x,x,x,...] contains no null
	 * @param assistList
	 * @return
	 */
	private static boolean isReachLeaf(Integer[] assistList) {
		int nullBegin = findNullBegin(assistList);
		if (nullBegin == assistList.length) {
			return true;
		}
		return false;
	}

}
