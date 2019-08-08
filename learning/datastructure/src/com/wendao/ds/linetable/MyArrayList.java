package com.wendao.ds.linetable;

import java.util.Arrays;

/**
 * 顺序表。
 * 底层用数组，但动态扩容。
 * @author china
 *
 */
@SuppressWarnings("all")
public class MyArrayList implements IList {
	
	/**
	 * 
	 */
	private Object[] elementData;
	
	/**
	 * num of elems
	 */
	private int size;
	
	public MyArrayList() {
		this(4); // 4
		
//		elementData = new Object[] {}; // 0
	}
	
	public MyArrayList(int initialCapacity) {
		elementData = new Object[initialCapacity];
		size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public Object get(int i) {
		if (i<0 || i>=size) {
//			throw new RuntimeException("数组索引越界异常: "+i);
			throw new MyArrayIndexOutOfBoundsException("数组索引越界异常: "+i);
		}
		
		return elementData[i];
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
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
			throw new MyArrayIndexOutOfBoundsException("数组索引越界异常");
		}
		if (size == elementData.length) {
			grow();
		}
		
		// 后移元素，从最后一个开始
		for(int j=size; j > i; j--) {
			elementData[j] = elementData[j-1];
		}
		
		elementData[i] = e;
		size++;
	}

	@Override
	public void add(Object e) {
		this.add(size, e);
	}
	
	private void grow() {
		int oldLen = elementData.length;
		int newLen = oldLen + (oldLen >> 1);
		elementData = Arrays.copyOf(elementData, newLen);
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
		// [1, 3, ...]
		if (size == 0) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder("[");
		for(int i=0; i<size; i++) {
			if (i != size-1) {
				sb.append(elementData[i]+",");
			} else {
				sb.append(elementData[i]);
			}
		}
		sb.append("]");
		
		return sb.toString();
	}

}














