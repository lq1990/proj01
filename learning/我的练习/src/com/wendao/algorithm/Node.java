package com.wendao.algorithm;

/**
 * 	节点：
 * 	boundVal，每个节点都有一个bound值
 * 	assistList：唯一标识一个node
 * @author china
 *
 */
public class Node {
	double boundVal; // 此node的价值上界，此为理想最优值
	Integer[] assistList; // 不仅与boundVal，还有对应的node。通过assistList可得知具体的node
							// eg. [1, 0, 1, null] 为 A B- C 的第三级的node
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