package cn.bjsxt.collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet µ×²ãÓÃ TreeMapÊµÏÖ
 * @author china
 *
 */
public class TestTreeSet {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();
		
		set.add(300);
		set.add(3002);
		set.add(3030);
		
		for(Integer i : set) {
			System.out.println(i);
		}
		
		System.out.println(set);
		
		Set<Emp> set2 = new TreeSet<>();
		set2.add(new Emp(100,"anna",3000));
		set2.add(new Emp(50,"beta",5000));
		set2.add(new Emp(1200,"cello",4000));
		set2.add(new Emp(10,"delta",3000));
		
		for(Emp e : set2) {
			System.out.println(e);
		}
	}
}
