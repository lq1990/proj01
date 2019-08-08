package com.wendao.ds.tree_hash_java;

import java.util.HashSet;
import java.util.TreeSet;

public class Test01 {
	public static void main(String[] args) {
		Double i = 1000.0;
		Double i2 = 1100.0;
		String s = "abc";
		String s2 = "abcd";
		System.out.println(i.hashCode());
		System.out.println(i2.hashCode());
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());
		
		System.out.println();
		
		TreeSet set = new TreeSet();
		set.add("abc");
		set.add("ddd");
		
		HashSet set2 = new HashSet<Object>();
		
		
	}
}
