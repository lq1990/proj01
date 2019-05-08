package cn.bjsxt.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * traverse List Set Map
 * @author china
 *
 */
public class TestIterator {
	public static void main(String[] args) {
		testIteratorList();
		System.out.println("##############");
		testIteratorSet();
		System.out.println("############");
		testIteratorMap();
	}
	
	public static void testIteratorList() {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");

		for(Iterator<String> iter= list.iterator(); iter.hasNext();) {
			String temp = iter.next();
			System.out.println(temp);
		}
	}
	
	public static void testIteratorSet() {
		Set<String> set = new HashSet<String>();
		set.add("asg");
		set.add("dfad");
		set.add("adfa");
		
		for(Iterator<String> iter = set.iterator(); iter.hasNext(); ) {
			String temp = iter.next();
			System.out.println(temp);
		}
	}
	
	public static void testIteratorMap() {
		Map<Integer, String> map1 = new HashMap<Integer, String>();
		
		map1.put(100,"aaa");
		map1.put(200,"bbb");
		map1.put(300,"ccc");
		
		// the first way to traverse Map
		Set<Entry<Integer, String>> ss = map1.entrySet();
		for(Iterator<Entry<Integer, String>> iter = ss.iterator(); iter.hasNext();) {
			Entry<Integer, String> temp = iter.next();
			System.out.println(temp.getKey()+" - "+temp.getValue());
		}
		
		// the second way
		Set<Integer> keySet = map1.keySet();
		for(Iterator<Integer> iter = keySet.iterator(); iter.hasNext();) {
			Integer key = iter.next();
			System.out.println(key+" -- "+ map1.get(key));
		}
		
		
		
	}
}
