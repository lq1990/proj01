package com.wendao.ds.linkedlist;

public interface IList {
	
	/**
	 * 返回线性表的大小，即数据元素的个数
	 * @return
	 */
	public int size();
	
	public Object get(int i);
	
	public boolean isEmpty();
	
	public boolean contains(Object e);
	
	public int indexOf(Object e);
	
	public void add(int i, Object e);
	
	/**
	 * append elem to the last position
	 * @param e
	 */
	public void add(Object e);
	
	/**
	 * insert e before obj
	 * @param obj
	 * @param e
	 * @return
	 */
	public boolean addBefore(Object obj, Object e);
	
	/**
	 * insert e after obj
	 * @param obj
	 * @param e
	 * @return
	 */
	public boolean addAfter(Object obj, Object e);
	
	public Object remove(int i);
	
	/**
	 * remove the first elem that is the same with e
	 * @param e
	 * @return
	 */
	public boolean remove(Object e);
	
	/**
	 * replace elem of index i with one new elem e
	 * @param i
	 * @param e
	 * @return old elem
	 */
	public Object replace(int i, Object e);
	
	
}

















