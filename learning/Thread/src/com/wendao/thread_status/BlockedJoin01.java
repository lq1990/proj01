package com.wendao.thread_status;

/**
 * join 合并线程，插队
 * 
 * @author china
 *
 */
public class BlockedJoin01 {
	public static void main(String[] args) throws InterruptedException {

		Thread t = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println("	lambda " + i);

			}
		});
		t.start();

		for (int i = 0; i < 100; i++) {
			System.out.println("main " + i);

			if (i == 20) {
				t.join(); // t线程 插队，main被阻塞
			}

		}

	}
}
