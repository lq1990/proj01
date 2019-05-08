package cn.bjsxt.collection;

/**
 * getA
 * 
 * @author china
 *
 */
public class SxtHashMap4<K,V> {

	Node3<K,V>[] table; // 位桶数组，bucket array
	int size; // 存放的键值对的个数
	
	public SxtHashMap4() {
		Node3[] node3s = new Node3[16];
		table = node3s;// 长度一般定义为2的整数次幂
	}
	

	public V get(K key) {
		int hash = myHash(key.hashCode(), table.length);

		V value = null;
		if (table[hash] != null) {
			Node3<K, V> temp = table[hash];
			
			while (temp!=null) {
				if (temp.key.equals(key)) { // 若相等，则找到了，返回value
					return temp.value;
				}
				temp = temp.next;
			}
		}

		return value;
	}

	public void put(K key, V value) {
		// put时，要考虑到 数组扩容

		Node3<K, V> newNode = new Node3<K, V>();
		newNode.hash = myHash(key.hashCode(), table.length); // hash value
		newNode.key = key;
		newNode.value = value;
		newNode.next = null;

		Node3<K, V> temp = table[newNode.hash];
		Node3<K, V> iterLast = null; // 正在遍历的最后一个元素
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
					return;
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
		
		size++;
	}

	public int myHash(int v, int length) {
//		System.out.println("hash in myHash &: " + (v & (length - 1)));
//		System.out.println("hash in myHash %: " + (v % length));
		return v & (length - 1);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{ ");

		for (int i = 0; i < table.length; i++) {
			Node3<?, ?> temp = table[i];

			while (temp != null) {
				sb.append(temp.key + ":" + temp.value + ", ");

				temp = temp.next;
			}
		}

		sb.delete(sb.length() - 2, sb.length() - 1);
		sb.append("}");
		return sb.toString();
	}

	public static void main(String[] args) {
		SxtHashMap4<Integer, String> m = new SxtHashMap4<Integer, String>();
		m.put(10, "aa");
		m.put(20, "bb");
		m.put(30, "cc");
		m.put(20, "ssss");
		
		m.put(53, "gg");
		m.put(69, "hh");
		m.put(85, "kk");

		System.out.println(m);
		System.out.println(m.size);

		System.out.println("###########");
		System.out.println(m.get(69));
		System.out.println(m.get(11));


	}
}
