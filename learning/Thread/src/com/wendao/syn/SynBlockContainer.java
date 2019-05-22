package com.wendao.syn;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 
 * @author china
 *
 */
public class SynBlockContainer {
	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<String>(); // Vector线程安全

		for (int i = 0; i < 10000; i++) {
			new Thread(() -> {
				synchronized (list) {
					list.add("abc");
				}
			}).start();
		}
		
		Thread.sleep(1000); // 给其它线程时间以运行
		
		System.out.println(list.size());

	}
}
