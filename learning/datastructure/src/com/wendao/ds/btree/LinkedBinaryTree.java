package com.wendao.ds.btree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LinkedBinaryTree implements IBinaryTree {
	
	private Node root;
	
	public LinkedBinaryTree() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param root
	 */
	public LinkedBinaryTree(Node root) {
		super();
		this.root = root;
	}


	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		System.out.println("二叉树节点个数：");
		return this.size(root);
	}
	
	/**
	 * 	递归的思想，从叶子节点0慢慢 +1，左右子树+1, 再左右子树
	 * @param root
	 * @return
	 */
	private int size(Node root) {
		if (null == root) {
			// 终止条件
			return 0;
		} else {
			// left
			int nl = this.size(root.leftChild);
			
			// right
			int nr = this.size(root.rightChild);
			
			// sum+1
			return nl+nr+1;
		}
		
	}

	@Override
	public int getHeight() {
		System.out.println("二叉树的高度：");
		int h = this.getHeight(root);
		return h;
	}
	
	/**
	 * 	因为树是 递归 定义的，所以最好用 递归 的思想取解决问题。
	 * @param root
	 * @return
	 */
	private int getHeight(Node root) {
		if (null == root) {
			return 0;
		} else {
			// 获取左子树的高度
			int nl = this.getHeight(root.leftChild);
			
			// 获取右子树的高度
			int nr = this.getHeight(root.rightChild);
			
			// 返回 max(nl, nr) + 1
			return nl > nr ? (nl+1) : (nr+1);
		}
	}

	@Override
	public Node findKey(Object data) {
		System.out.println("findKey: ");
		return this.findKey(data, root);
	}
	
	private Node findKey(Object data, Node root) {
		if (null == root) { // root of each tree or subtree
			return null;
		} else if (null != root && root.data == data) { // find it
			return root;
		} else {
			Node left = this.findKey(data, root.leftChild);
			Node right = this.findKey(data, root.rightChild);
			if (null != left && left.data == data) {
				return left;
			} else if (null != right && right.data == data) {
				return right;
			} else {
				return null;
			}
		}
	}

	@Override
	public void preOrderTraverse() {
		// root
		if (null != root) {
			// 1. output data
			System.out.print(root.data+" ");
			
			// 2. traverse left subtree
			LinkedBinaryTree leftTree = new LinkedBinaryTree(root.leftChild);
			leftTree.preOrderTraverse();
			
			// 3. traverse right subtree
			LinkedBinaryTree rightTree = new LinkedBinaryTree(root.rightChild);
			rightTree.preOrderTraverse();
		}
		
	}

	@Override
	public void inOrderTraverse() {
		System.out.println("中序遍历：");
		
		this.inOrderTraverse(root);
		
		System.out.println();
	}
	
	private void inOrderTraverse(Node root) {
		if (null != root) {
			// left
			this.inOrderTraverse(root.leftChild);
			
			// data
			System.out.print(root.data+" ");
			
			// right
			this.inOrderTraverse(root.rightChild);
		}
	}

	@Override
	public void postOrderTraverse() {
		System.out.println("后续遍历：");
		this.postOrderTraverse(root);
		System.out.println();
	}
	
	private void postOrderTraverse(Node root) {
		if (null != root) {
			// left
			this.postOrderTraverse(root.leftChild);
			
			// right
			this.postOrderTraverse(root.rightChild);
			
			// data of root
			System.out.print(root.data+" ");
		}
	}

	@Override
	public void inOrderByStack() {
		System.out.println("中序遍历（借助栈）：");
		
		Deque<Node> stack = new LinkedList<Node>();
		Node cur = root;
		while(null != cur || !stack.isEmpty()) {
			while(null != cur) {
				stack.push(cur);
				cur = cur.leftChild;
			}
			// this moment, cur = null, reach a leaf node
			
			if (!stack.isEmpty()) {
				cur = stack.pop(); // get the root of subtree
				// root
				System.out.print(cur.data+" ");
				// right
				cur = cur.rightChild;
			}
		}
		
		System.out.println();
	}

	@Override
	public void preOrderByStack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postOrderByStack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void levelOrder() {
		System.out.println("按照层次遍历二叉树（借助队列）：");
		
		if (null == root) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while(queue.size() != 0) {
			for(int i=0; i<queue.size(); i++) {
				Node tmp = queue.poll();
				System.out.print(tmp.data + " ");
				if (null != tmp.leftChild) {
					queue.offer(tmp.leftChild);
				}
				if (null != tmp.rightChild) {
					queue.offer(tmp.rightChild);
				}
			}
			
		}
		
		System.out.println();
	}

}


















