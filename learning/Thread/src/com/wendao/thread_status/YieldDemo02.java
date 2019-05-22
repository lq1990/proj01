package com.wendao.thread_status;

/**
 * mian 中 yield
 * @author china
 *
 */
public class YieldDemo02 {

	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("	lambda " + i);
			}
		}).start();

		for (int i = 0; i < 100; i++) {
			System.out.println("main " + i);
			
			if (i % 20 == 0) {
				Thread.yield();
			}
			
		}

	}

}
