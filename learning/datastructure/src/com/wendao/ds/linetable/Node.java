package com.wendao.ds.linetable;

/**
 * 
 * @author china
 *
 */
public class Node {
	
	Object data;
	
	Node next;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	public Node() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param data
	 * @param next
	 */
	public Node(Object data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}

	/**
	 * @param data
	 */
	public Node(Object data) {
		super();
		this.data = data;
	}
	
	
}
