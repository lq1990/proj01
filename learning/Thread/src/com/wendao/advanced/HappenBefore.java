package com.wendao.advanced;

/**
 * 在多线程时，
 * 指令重排 happenbefore
 * 代码的实行顺序 与 预期的不一致。 目的：提高性能。
 * 
 * 发生在: 数据没有依赖时，JVM为了提高性能，会不按照我们书写的顺序执行。
 * 
 * @author china
 *
 */
public class HappenBefore {
	private static int a = 0;

	private static boolean flag = false;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("main");
		
		Thread t1 = new Thread(() -> {
			a = 1;
			flag = true;
		});

		Thread t2 = new Thread(() -> {
			if (flag) {
				a *= 1;
			}
			if (a == 0) {
				System.out.println("happenbefore, a: " + a);
			}
		});
		
		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}
}
