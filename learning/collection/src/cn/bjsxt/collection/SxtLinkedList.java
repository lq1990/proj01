package cn.bjsxt.collection;

/**
 * 
 * @author china
 *
 */
public class SxtLinkedList {
	private Node first; // 双向链表，只要获得了 头或尾，就可以找到其它的了
	private Node last; // 双向链表的尾

	private int size = 0;

	public void add(Object obj) {
		Node n = new Node();

		if (first == null) {
			n.prev = null;
			n.obj = obj;
			n.next = null;

			first = n;
			last = n;
		} else {
			// 直接往last节点后增加新的节点
			n.prev = last; // last <- n
			n.obj = obj;
			n.next = null;

			last.next = n; // 因为是双向链表，last -> n
			last = n;
		}

		size++;
	}

	public int size() {
		return size;
	}

	public Object get(int index) {
		// 越界处理
		rangeCheck(index);

		Node temp = node(index);
		if (temp != null) {
			return temp.obj;
		}
		return null;
	}

	public void remove(int index) {
		rangeCheck(index);

		Node temp = node(index);

		// 此时：temp 为index处
		if (temp != null) {
			if (index == 0) {
				first = temp.next;
				first.prev = null;
			} else if (index == size - 1) {
				last = temp.prev;
				last.next = null;
			} else {
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				temp = null; // let gc do its work
//				Node up = temp.prev;
//				Node down = temp.next;
//				up.next = down;
//				down.prev = up;
			}

			size--;
		}

	}

	public void add(int index, Object obj) {
		rangeCheck(index);

		Node objNode = new Node(null, obj, null);

		Node temp = node(index);
		if (index != 0) {
			temp.prev.next = objNode;
			temp.prev = objNode;

			objNode.prev = temp.prev;
			objNode.next = temp;
		} else {
			temp.prev = objNode;
			first = objNode;
			// 把first这个头衔 给objNode。考虑到node中从first开始遍历，所以first勿忘及时更新

			objNode.prev = null;
			objNode.next = temp;

			System.out.println("first.obj: " + first.obj);
		}
		size++;

	}

	/**
	 * get the element of index
	 * 
	 * @param index
	 * @return
	 */
	public Node node(int index) {
		Node temp = null;
		if (first != null) { // 从first开始找
			temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
		}

		return temp;
	}

	public void rangeCheck(int index) {
		if (index > size - 1 || index < 0) {
			try {
				throw new IndexOutOfBoundsException();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static void showLinkedList(SxtLinkedList list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static void main(String[] args) {
		SxtLinkedList list = new SxtLinkedList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		System.out.println(list.size());

		showLinkedList(list);
		System.out.println("##########");
		list.remove(1);
		System.out.println(list.size());
		showLinkedList(list);
		System.out.println("##########");
		list.add(0, "jjj");
		showLinkedList(list);

	}

}
