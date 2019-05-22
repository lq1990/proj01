package com.wendao.advanced;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS 设计juc高级并发编程
 * 
 * @author china
 *
 */
public class CompareAndSwap {
	// AtomicInteger
	private static AtomicInteger stock = new AtomicInteger(5);

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Integer left = stock.decrementAndGet();
				
				if (left < 1) {
					System.out.println("抢完了...");
					return;
				}
				System.out.println(Thread.currentThread().getName() + "抢到了一件");
				System.out.println("	还剩 " + left);
				
			}).start();

		}
	}
}
