package cn.bjsxt.collection;

import java.util.ArrayList;

import javax.lang.model.element.Element;

/**
 * make a ArrayList by myself
 * 
 * @author china
 *
 */
public class SxtArrayList {

	private Object[] elementData;

	/**
	 * distinguish size and length size: number of elements length: capacity
	 */
	private int size;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public SxtArrayList() {
		this(10);
	}

	public SxtArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		elementData = new Object[initialCapacity];
	}

	public void ensureCapacity() {
		// 数组扩容、拷贝
		if (size >= elementData.length) {
			Object[] newArr = new Object[(size << 1) + 1]; // 注意：位运算符优先级 低于 加减
			System.arraycopy(elementData, 0, newArr, 0, elementData.length);

			elementData = newArr;
		}
	}

	public void add(Object obj) {
		ensureCapacity();

		this.elementData[size++] = obj;
	}

	public void add(int index, Object obj) {
		rangeCheck(index);
		ensureCapacity();

		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		this.elementData[index] = obj;
		size++;

	}

	public Object get(int index) {
		rangeCheck(index);

		return this.elementData[index];
	}

	public Object set(int index, Object obj) {
		rangeCheck(index);

		Object oldValue = elementData[index];
		elementData[index] = obj;

		return oldValue;
	}

	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param index
	 */
	public void remove(int index) {
		rangeCheck(index);

		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		}

		elementData[--size] = null;
	}

	public void remove(Object obj) {
		for (int i = 0; i < size; i++) {

			if (get(i).equals(obj)) {
				remove(i);
				return;
			}
		}
	}

	public static void main(String[] args) {

		SxtArrayList list = new SxtArrayList(0);
		list.add("aaa");
		list.add("bbb");
		list.add(12);
		list.add(122);
		list.add(123);
		list.add(124);
		list.add(125);
		list.add(126);
//		System.out.println(list.size());
//		System.out.println(list.elementData.length);
//		System.out.println(list.get(10));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("##############");
		list.remove("aaa");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
