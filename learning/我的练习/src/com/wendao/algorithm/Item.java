package com.wendao.algorithm;

/**
 * <strong>item of products</strong>
 * <pre>
 * 
 * field:
 * 	weight
 * 	value
 * 	val_pre_unit_weight
 * </pre>
 * @author china
 *
 */
public class Item implements Comparable<Item> {
	int weight;
	int value;
	double val_per_unit_weigth;
	Integer isUse; // 判断当前item是否使用 true(使用)/false(不用)/null(未知)

	public Item(int weight, int value) {
		super();
		this.weight = weight;
		this.value = value;
		this.val_per_unit_weigth = (double)this.value / this.weight;
	}
	
	@Override
	public int compareTo(Item o) {
		if (this.val_per_unit_weigth <= o.val_per_unit_weigth) {
			return 1;
		} else {
			return -1;
		}
	}
}
