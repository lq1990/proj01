package cn.bjsxt.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author china
 *
 */
public class Test01 {
	public static void main(String[] args) {
		List list = new ArrayList();
		// ArrayList: 底层用 数组实现，查询快，但插入删除慢。线程不安全。
		// LinkedList：底层是链表，查询慢，但插入删除快。线程不安全。
		// Vector：底层用数组，线程安全的，但效率低。
		
		list.add("aaa");
		list.add(new Date());
		list.add(new Dog());
		list.add(1234);
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(list);
		
//		list.remove("aaa");
//		System.out.println(list.size());
//		
		List list2 = new ArrayList();
		list2.add("bb");
		list2.add("ccc");
		
		list.add(list2);
		System.out.println(list);
		System.out.println(list.size());
		
		System.out.println("###############");
		// 跟顺序的操作
		String a = (String) list.get(0);
		System.out.println(a);
		
		list.set(1, "1jasjkdgj");
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		
	}
}

class Dog {
	
}