package cn.bjsxt.collection;

import java.util.HashMap;

/**
 * self def HashSet
 * 
 * @author china
 *
 */
public class SxtHashSet {
	HashMap map;

	private static final Object PRESENT = new Object();

	public SxtHashSet() {
		map = new HashMap();
	}

	public int size() {
		return map.size();
	}

	public void add(Object obj) {
		map.put(obj, PRESENT);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		
		for(Object k : map.keySet()) {
			sb.append(k+",");
		}
		
		sb.setCharAt(sb.length()-1, '}');
		return sb.toString();
	}

	public static void main(String[] args) {
		SxtHashSet set = new SxtHashSet();
		set.add("aaa");
		set.add("bbb");
		set.add("aaacc");
		set.add("aaadaf");

		System.out.println(set);
	}

}
