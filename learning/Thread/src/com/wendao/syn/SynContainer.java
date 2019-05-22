package com.wendao.syn;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

/**
 * 线程安全： 操作并发容器
 * 
 * @author china
 *
 */
public class SynContainer {
	public static void main(String[] args) {
		List<String> list = new CopyOnWriteArrayList<String>();

		for (int i = 0; i < 10000; i++) {
			new Thread(() -> {
				list.add("aaa");
			}).start();
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(list.size());
	}
}
