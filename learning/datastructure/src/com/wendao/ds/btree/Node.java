package com.wendao.ds.btree;

public class Node {

	Object data; // 数据

	Node leftChild; // 左子树的引用

	Node rightChild; // 右子树的引用

	/**
	 * @param data
	 * @param leftChild
	 * @param rightChild
	 */
	public Node(Object data, Node leftChild, Node rightChild) {
		super();
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}

}
