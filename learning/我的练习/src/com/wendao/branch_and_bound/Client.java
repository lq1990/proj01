package com.wendao.branch_and_bound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 * 分支限界法 Branch and Bound
 * Bound: 计算每个节点总价值的上界
 * 
 * 解决：背包问题
 * 背包容量：9kg
 * 
 * 四件商品：        A    B    C    D
 *         重量：       3       2       5       4    kg
 *         价值：      66     40     95      40   RMB
 * 单位重量价值： 22     20     19     10   
 * 
 * 步骤：
 * 1. 将问题使用二叉树建模
 *  					     start
 *  				A						A-
 *  			B			B-			B			B-
 *  		C		C-	C		C-	C		C-	C		C-
 * 		D		D-
 * 
 * 2. 从起始点开始，计算 左/右子树 的最优价值即上界，将结果存入列表，
 * 3. 扫描列表，选择价值大的为新节点
 * 4. 重复234
 * 5. 终止条件：当达到叶子节点，则此叶子节点的价值即是 真实最优解，所对应的路径是最优路径。
 * 	*因为：当叶子节点的真实最优值都大于列表中其它节点理解最优值时，显然叶子节点是左右可能节点的最优。
 * 
 * 
 * </pre>
 * 
 * @author china
 *
 */
public class Client {
	private static List<Node> boundList = new ArrayList<Node>(); // store bounds
	private static List<Item> products = new ArrayList<Item>();
	private static final double MAXWEIGHT = 9;
	private static Node maxBoundValNode;
	private static double boundVal;

	public static void main(String[] args) {
		// 1. 背包问题建模，使用二叉树
		// init 物品列表
		products.add(new Item(3, 66));
		products.add(new Item(2, 40)); // weight, value
		products.add(new Item(4, 40));
		products.add(new Item(5, 95));
		// List 排序，按照 val_per_uni_weight 从高到低
		Collections.sort(products);
		
		// init boundList，用A=true/false 两种情况初始化boundList

		// 创建二叉树，树中有node和arc。node连接最多3条arc指向3个其它node，arc有自己的权值
		// 若计算出每个node的bound，太耗时。不必如此。

		// 省时的方法：一级级往下纵深，贪婪算法，先选择bound大的节点递归，当到达叶子节点且叶子节点的profit大于其他所有list中节点bound时，则完全终止。
		// 若到达某个node超重时，也终止当前路径。

		// 二叉树方便理解，但是实际上可以不创建 树。
		// List中（index+1）即是 二叉树的level

		// 关于可以递归的地方：
		// 从起始节点开始，计算左右节点的bound，将bounds值放到list存储，拿到list中最大的bound对应的节点为新的节点

		// =========== 从 A: 1/0 开始 ===========
		// A = 1, [1, null, null, null]
		Integer[] assistList = { null, null, null, null }; // 此idx对应于 products 列表的
		
		for (int i = 0; i < assistList.length; i++) {
			products.get(i).isUse = assistList[i];
		}
		
		// init boundList and maxBoundValNode
		calcLeftRightBoundAddToBoundList(assistList);
		maxBoundValNode = boundList.get(0);
		MyUtils.printBoundList(boundList);
		
		
		// 拿到 boundList中最大的boundVal对应的node，继续
		int tmp = 0;
		while(ifMaxBoundNodesAssistListContainsNull()) {
			// contains null 表示：还没有到叶子
			System.out.println("loop: "+tmp++);
			updateMaxBoundValNodeInList(); // 贪心算法，先计算当前 max
			calcLeftRightBoundAddToBoundList(maxBoundValNode.assistList);
			// rm oldMax
			boundList.remove(maxBoundValNode);

			MyUtils.printBoundList(boundList);
			
		}
		
		// get optimal
		updateMaxBoundValNodeInList();
		System.out.println("best: "+maxBoundValNode.boundVal+", "+Arrays.toString(maxBoundValNode.assistList));
		
		// 考虑超重时，当前路径直接停止。
		// 当前完全终止条件不对，应该是：到达叶子节点，且叶子节点的profit大于其他bound
		
		
		// 当前没用递归，考虑使用递归改善

	}
	
	public static boolean ifMaxBoundNodesAssistListContainsNull() {
		updateMaxBoundValNodeInList();
		Integer[] al = maxBoundValNode.assistList;	
		for (Integer integer : al) {
			if (integer == null) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void updateMaxBoundValNodeInList() {
		Node maxNode = boundList.get(0);
		
		for (Node node : boundList) {
			if(node.boundVal > maxNode.boundVal) {
				maxNode = node;
			}
		}
		
		maxBoundValNode = maxNode;
	}
	
	/**
	 * calc left and right bound of a node, and update boundList，
	 * get the node with max. boundVal, then loop
	 */
	public static void calcLeftRightBoundAddToBoundList(Integer[] assistList) {
		// find nullBegin
		int nullBegin = 0; // assistList 中从 nullBegin 开始为null
		for(int i=0; i<assistList.length; i++) {
			if (assistList[i] == null) {
				nullBegin = i;
				break;
			}
		}
		
		// left bound of the node that's represented by assistList
		Integer[] assistListCpLeft = Arrays.copyOf(assistList, assistList.length);
		Integer[] assistListCpRight = Arrays.copyOf(assistList, assistList.length);
		
		
		// 一次只进行一层，即只改变一个null
		assistListCpLeft[nullBegin] = 1;
		boolean isOverWeight = calcBoundForAssistList(assistListCpLeft);
		if (!isOverWeight) {
			boundList.add(new Node(boundVal, assistListCpLeft)); // update boundList
		}
		
		
		// right bound of the node
		assistListCpRight[nullBegin] = 0;
		isOverWeight = calcBoundForAssistList(assistListCpRight);
		if (!isOverWeight) {
			boundList.add(new Node(boundVal, assistListCpRight)); // update boundList
		}
		
	}
	
	/**
	 * 	给出assistList，计算其node的boundVal
	 * 
	 * 	给出任意的assistList，都可以计算其左右子树的bound，并更新boundList
	 * 
	 * 
	 * eg. assistList [1, 0, null, null] 则应计算 [1, 0, 1/0, null] 两个bound
	 * 且更新boundList，即把 [1,0,null,null]对应的node --> 替代为 [1, 0, 1/0, null]对应的两个node
	 * 
	 * @param assistList
	 * @return true/false 是否超重
	 */
	public static boolean calcBoundForAssistList(Integer[] assistList) {
		// 若超重，直接return true
		if (isOverWeight(assistList)) {
			return true;
		}
		
		// 先计算已经确定的node的 cumsumWeight bound
		double cumsumWeight = 0;
		double restWeight = MAXWEIGHT - cumsumWeight;
		double bound = 0;
		int nullBegin = 0; // 记录assistList中第一个null的idx
		for (int i = 0; i < assistList.length; i++) {
			// 有可能 assistList 都不是null，且遍历到了最后
			if (i == assistList.length-1) {
				nullBegin = assistList.length;
			}
			
			Integer intVal = assistList[i];
			if (null == intVal) {
				nullBegin = i;
				break;
			}
			
			if (intVal != 0) {
				// 说明use了这个物品
				cumsumWeight += products.get(i).weight;
				restWeight = MAXWEIGHT - cumsumWeight;
				bound += products.get(i).value;
				
				// 当前不超重
//				if (cumsumWeight <= MAXWEIGHT) {
					// 若剩余空间不足，也就无法再放物品了，就不能加profit了
					// restWeight >=0 表示 cumsumWeight <= MAXW
//					bound += products.get(i).value;
//				} 
//				else {
////					// 最后一件只能拆分了
//					bound += (MAXWEIGHT - (cumsumWeight - products.get(i).weight)) * products.get(i).val_per_unit_weigth;
//					break;
//				}
//				System.out.println("restWeight: "+restWeight+", profit: "+profit);
			}
			
		}
		
//		bound += profit;
		
		// 对未知的路径，求bound。即从nullBegin idx开始
		for(int i = nullBegin; i < products.size(); i++) {
			if (products.get(i).weight <= restWeight) {
				cumsumWeight += products.get(i).weight;
				bound += products.get(i).value;
				restWeight = MAXWEIGHT - cumsumWeight;
			} else {
				// 此时restWeight < item.Weight，假定item可拆解重量
				bound += products.get(i).val_per_unit_weigth * restWeight;
				break;
			}
		}
		
		boundVal = bound;
		return false;
	}
	
	public static boolean isOverWeight(Integer[] assistList) {
		Integer[] al = assistList;
		double wSum = 0;
		for (int i=0; i< al.length; i++) {
			if (null != al[i]) {
				int w = products.get(i).weight;
				wSum += al[i]*w;
			}
		}
		
		if (wSum > MAXWEIGHT) {
			System.out.println("				overweight : "+Arrays.toString(assistList));
			return true;
		}
		
		return false;
	}

}













