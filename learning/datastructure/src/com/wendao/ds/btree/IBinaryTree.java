package com.wendao.ds.btree;

public interface IBinaryTree {
	
	public boolean isEmpty();
	
	public int size();
	
	public int getHeight();
	
	/**
	 * 	查询指定值的节点
	 * @param value
	 * @return
	 */
	public Node findKey(Object value);
	
	/**
	 * 	递归 先序遍历
	 */
	public void preOrderTraverse();
	
	public void inOrderTraverse();
	
	public void postOrderTraverse();
	
	
	/**
	 * 	中序遍历，非递归操作
	 */
	public void inOrderByStack();
	
	public void preOrderByStack();
	
	public void postOrderByStack();
	
	/**
	 * 	按照层次遍历二叉树。
	 * 	借助队列。
	 */
	public void levelOrder();

	
}























