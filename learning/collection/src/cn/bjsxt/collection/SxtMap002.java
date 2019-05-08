package cn.bjsxt.collection;

/**
 * 自定义Map 升级版 1. 提高效率
 * 
 * @author china
 *
 */
public class SxtMap002 {
	SxtLinkedList[] arr = new SxtLinkedList[999]; // 数组中存储 链表

	int size;

	public void put(Object key, Object value) {
//		System.out.println(key.hashCode()); // 根据key的地址 生成hashCode

		SxtEntry e = new SxtEntry(key, value);
		int code = key.hashCode() % arr.length;

		if (arr[code] == null) {
			arr[code] = new SxtLinkedList();
			arr[code].add(e);

		} else {
			// 检查是否已有key
			for (int i = 0; i < arr[code].size(); i++) {
				// 取arr的code位置处链表的第i位置的obj
				SxtEntry eGet = (SxtEntry) arr[code].get(i);

				if (eGet.key.equals(key)) {
					eGet.value = value;
					return;
				}
			}
			
			// 此时，key没重复
			arr[code].add(e);

		}

		size++;

	}

	public Object get(Object k) {
		int code = k.hashCode() % arr.length;

		if (arr[code] != null) {
			// 此时code处，链表有一个或多个元素
			for (int i = 0; i < arr[code].size(); i++) {
				SxtEntry eGet = (SxtEntry) arr[code].get(i);
				if (eGet.key.equals(k)) {
					return eGet.value;
				}
			}
		}

		return null;
	}

	public static void main(String[] args) {

		SxtMap002 mp = new SxtMap002();
		mp.put("abc", 123);
		mp.put("jkjk", 444);
		mp.put("eee", 555);
//		mp.put("eee", 777);
		System.out.println(mp.get("eee"));

//		String s = "abc";
//		String s2 = "aabc";
//		System.out.println(s.hashCode());
//		System.out.println(s2.hashCode());

	}

}
