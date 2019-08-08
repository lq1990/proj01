package com.wendao.ds.linkedlist;

public class Node {
	
	Node prev;
	
	Object data;
	
	Node next;

	/**
	 * @param prev
	 * @param data
	 * @param next
	 */
	public Node(Node prev, Object data, Node next) {
		super();
		this.prev = prev;
		this.data = data;
		this.next = next;
	}
	
	public Node() {
		// TODO Auto-generated constructor stub
	}
	
}
