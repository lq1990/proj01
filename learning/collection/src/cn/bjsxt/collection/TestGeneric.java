package cn.bjsxt.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author china
 *
 */
public class TestGeneric {
	public static void main(String[] args) {
		MyCollection<String> mc = new MyCollection<String>();

		mc.set("anna", 0);
//		mc.set(8888, 1);

//		Integer i = (Integer) mc.get(1); // 需要强制转型
		String n = mc.get(0);

//		System.out.println(i);
		System.out.println(n);
		
		System.out.println("#############");
		List list = new ArrayList();
		Map mp = new HashMap();
		
	}
}

class MyCollection<E> {
	Object[] objs = new Object[5];

	public void set(E e, int index) {
		objs[index] = e;
	}

	public E get(int index) {
		return (E) objs[index];
	}

}
