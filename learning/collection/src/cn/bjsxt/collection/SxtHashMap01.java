package cn.bjsxt.collection;

/**
 * self def Map
 * 
 * @author china
 *
 */
public class SxtHashMap01 {

	Node2[] table; // 位桶数组，bucket array
	int size; // 存放的键值对的个数

	public SxtHashMap01() {
		table = new Node2[16]; // 长度一般定义为2的整数次幂

	}

	public void put(Object key, Object value) {
		Node2 newNode = new Node2();
		newNode.hash = myHash(key.hashCode(), table.length); // hash value
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;

		Node2 temp = table[newNode.hash];
		Node2 iterLast = null; // 正在遍历的最后一个元素
		boolean keyRepeat = false;
		
		if (temp == null) {
			// 此处数组元素为空，则直接将新节点放进去
			table[newNode.hash] = newNode;
		} else {
			// 遍历链表
			while (temp != null) {
				if (temp.key.equals(key)) {
					keyRepeat = true;
					// 若key重复，则覆盖
					temp.value = value;
					break;
				} else {
					// key不重复
					iterLast = temp;
					temp = temp.next;
					
				}
			}
			
			if (!keyRepeat) {
				iterLast.next = newNode;
			}
			
			
		}
	}

	public int myHash(int v, int length) {
		System.out.println("hash in myHash &: " + (v & (length - 1)));
		System.out.println("hash in myHash %: " + (v % length));
		return v & (length - 1);
	}

	public static void main(String[] args) {
		SxtHashMap01 m = new SxtHashMap01();
		m.put(10, "aaa");
		m.put(20, "bb");
		m.put(30, "cccc");
		m.put(10, "abc");
		m.put(26, "awd");

		System.out.println(m);
	}
}
