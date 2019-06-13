package com.wendao.branch_and_bound04;

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
