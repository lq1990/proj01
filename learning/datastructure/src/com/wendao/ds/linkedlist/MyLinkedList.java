package com.wendao.ds.linkedlist;


public class MyLinkedList implements IList {
	
	private int size;
	
	private Node first;
	
	private Node last;
	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Object e) {
		final Node l = last;
		Node newNode = new Node(l, e, null);
		last = newNode;
		if (null == l) {
			first = newNode;
		} else {
			l.next = newNode;
		}
		size++;
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

}
