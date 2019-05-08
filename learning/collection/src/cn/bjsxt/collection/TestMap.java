package cn.bjsxt.collection;

import java.util.HashMap; // 线程不安全
import java.util.Hashtable; // 线程安全
import java.util.Map; // Map interface

/**
 * test Map basic use
 * @author china
 *
 */
public class TestMap {
	public static void main(String[] args) {
		Map map = new Hashtable();
		
		map.put("zhangsan", new Wife("anna"));
		System.out.println(map);
		
		map.put("lisi", "beta");
		System.out.println(map);
		
		Wife w = (Wife) map.get("zhangsan");
		System.out.println(w.name);
		
		map.remove("zhangsan");
		System.out.println(map);
		
		map.put("lisi", "cello");
		System.out.println(map);
		
	}

}

class Wife {
	String name;
	
	public Wife(String name) {
		this.name = name;
	}
}


