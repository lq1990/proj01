package com.wendao.ds.btree;

public class Test {
	public static void main(String[] args) {
		// create a btree
		Node node5 = new Node(5, null, null);
		Node node4 = new Node(4, null, node5);
		Node node3 = new Node(3, null, null);
		Node node7 = new Node(7, null, null);
		Node node6 = new Node(6, null, node7);
		Node node2 = new Node(2, node3, node6);
		Node node1 = new Node(1, node4, node2);
		
		LinkedBinaryTree btree = new LinkedBinaryTree(node1);
		
		// isEmpty()
		System.out.println("isEmpty(): "+btree.isEmpty());
		
		// preOrderTraverse
		System.out.println("先序遍历：");
		btree.preOrderTraverse();
		System.out.println();
		
		// inOrderTraverse
		btree.inOrderTraverse();
		
		// postOrderTraverse
		btree.postOrderTraverse();
		
		// inOrderByStack
		btree.inOrderByStack();
		
		// postOrderByStack
		
		
		// levelOrder 借助队列
		btree.levelOrder();
		
		
		// 查找某个值
		System.out.println(btree.findKey(7));
		
		
		// 二叉树的高度
		System.out.println(btree.getHeight());
		
		// 二叉树的节点数量
		System.out.println(btree.size());
		
		
		
	}
}





























