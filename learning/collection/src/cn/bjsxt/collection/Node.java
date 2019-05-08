package cn.bjsxt.collection;

public class Node {
	Node prev;
	Object obj; // 本节点存储的数据，只有这个对client而言才是有用的。
	Node next;
	
	public Node() {
		
	}
	
	public Node(Node prev, Object obj, Node next) {
		super();
		this.prev = prev;
		this.obj = obj;
		this.next = next;
	}
	
	
}
