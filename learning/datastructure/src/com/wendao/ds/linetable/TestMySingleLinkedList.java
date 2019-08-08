package com.wendao.ds.linetable;

import java.util.ArrayList;
import java.util.Vector;

public class TestMySingleLinkedList {
	public static void main(String[] args) {
		
		MySingleLinkedList list = new MySingleLinkedList();
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		list.add(16);
		list.add(17);
		list.add(18);
		list.add(10, 99);
		
		System.out.println("size:    "+list.size());
		System.out.println("isEmpty: "+list.isEmpty());
		System.out.println(list.toString());
		System.out.println(list.get(1));
		
		
	}
}
