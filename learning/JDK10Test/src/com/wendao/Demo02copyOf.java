package com.wendao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author china
 *
 */
public class Demo02copyOf {
	public static void main(String[] args) {
		var list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		
		var list2 = List.copyOf(list);
//		list2.add("e");
		
		
		
		for (Object object : list2) {
			System.out.println(object);
		}
		
	}
}
