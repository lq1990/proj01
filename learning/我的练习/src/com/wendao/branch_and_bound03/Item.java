package com.wendao.branch_and_bound03;

/**
 * item of products
 * 	1. weight
 * 	2. value
 * 	3. val/w
 * 
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
	 * @param val_per_unit_w
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
