package com.wendao.branch_and_bound03;

/**
 * info of node
 * 	1. boundVal : bound value
 * 	2. assistList : identify the node. eg. [1, 0, null, null] --> A B- ? ?
 * 
 * @author china
 *
 */
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
