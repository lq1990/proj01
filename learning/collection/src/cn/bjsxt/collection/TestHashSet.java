package cn.bjsxt.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * test HashSet
 * @author china
 *
 */
public class TestHashSet {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>();
		Set<String> set2 = new HashSet<String>();
		
		set1.add("aa");
		set1.add("ss");
		set1.add("aa");
		set1.add("dd");
		System.out.println(set1);
		
		set1.remove("ss");
		System.out.println(set1);
		
		
		set2.add("aa");
		set2.add("qqq");
		System.out.println(set2);
		System.out.println(set2.retainAll(set1)); // ½»¼¯
		System.out.println(set2);
		System.out.println(set2.hashCode());
		
	}
}
