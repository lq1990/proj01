package com.wendao.branch_and_bound04;

public class Node {
	double boundVal;
	Integer[] assistList;
	
	/**
	 * @param boundVal
	 * @param assistList
	 */
	public Node(double boundVal, Integer[] assistList) {
		super();
		this.boundVal = boundVal;
		this.assistList = assistList;
	}
	
}
