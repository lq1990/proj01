package com.wendao.syn;

import java.util.List;
import java.util.Vector;

/**
 * 
 * @author china
 *
 */
public class UnsafeTest03Container {
	public static void main(String[] args) {
		List<String> list = new Vector<String>(); // Vector竟然也不 线程安全

		for (int i = 0; i < 10000; i++) {
			new Thread(() -> {
				list.add(Thread.currentThread().getName());
			}).start();
		}
		
		System.out.println(list.size());

	}
}
