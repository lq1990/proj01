package com.wendao.branch_and_bound02;

/**
 * <pre>
 * items in knapsack
 * 	
 *          A    B    C    D
 * weight:  3    2    5    4  KG
 * value:  66   40   95   40  RMB
 * val/w:  22   20   19   10
 * 
 * </pre>
 * @author china
 *
 */
public class Item implements Comparable<Item> {
	double weight;
	double value;
	double val_per_unit_w;
	
	/**
	 * @param weight
	 * @param value
	 */
	public Item(double weight, double value) {
		super();
		this.weight = weight;
		this.value = value;
		this.val_per_unit_w = value / weight;
	}
	
	@Override
	public int compareTo(Item o) {
		if (this.val_per_unit_w < o.val_per_unit_w) {
			return 1;
		} else {
			return -1;
		}
	}
	
	
}
