package cn.bjsxt.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections
 * @author china
 *
 */
public class TestCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<10;i++) {
			list.add("gao"+i);
		}
		
		System.out.println(list);
		
		Collections.shuffle(list); // shuffle
		System.out.println(list);
		
		Collections.reverse(list);
		System.out.println(list);
		
		Collections.sort(list); // 自定义的类，请实现 Comparable interface
		System.out.println(list);
		
		int res = Collections.binarySearch(list, "gao2");
		System.out.println(res);
	}
}
