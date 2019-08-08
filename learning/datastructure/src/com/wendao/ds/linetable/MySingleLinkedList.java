package com.wendao.ds.linetable;

public class MySingleLinkedList implements IList {
	
	private Node head = new Node(null, null); // dummy node, it has no data
	
	private int size;

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object get(int i) {
		Node p = head;
		for(int j=0; j<=i; j++) {
			p = p.next;
		}
		return p.data;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean contains(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(int i, Object e) {
		
		if (i<0 || i>size) {
			throw new MyArrayIndexOutOfBoundsException("数组指针越界异常:"+i);
		}
		
		// 先新建一个node
		Node newNode = new Node(e, null);
		
		Node prevNode = head;
		for(int j=0; j<i; j++) {
			prevNode = prevNode.next;
		}
		// 到这里，就找到了 prevNode的地址，即newNode应插入位置的前驱node
		
		newNode.next = prevNode.next;
		prevNode.next = newNode;
		
		size++;
	}

	@Override
	public void add(Object e) {
		this.add(size, e);
	}

	@Override
	public boolean addBefore(Object obj, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAfter(Object obj, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object replace(int i, Object e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		
		Node tmp = head.next;
		for(int i=0; i<size; i++) {
			if (i != size-1) {
				sb.append(tmp.data+",");
			} else {
				sb.append(tmp.data);
			}
			
			tmp = tmp.next;
		}
		sb.append("]");
		
		return sb.toString();
	}

}











