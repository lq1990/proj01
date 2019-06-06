package com.wendao.branch_and_bound02;

/**
 * used in List<Node> boundList;
 * info of node:
 * 		boundVal
 * 		assistList
 * 
 * eg. assistList: [1, 0, null, null] --> [A B- ? ?]
 * 
 * @author china
 *
 */
public class Node {
	double boundVal; // bound value
	Integer[] assistList; // to identify the node
	
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
