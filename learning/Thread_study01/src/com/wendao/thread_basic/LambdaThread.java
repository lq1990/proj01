package com.wendao.thread_basic;

/**
 * Lambda 表达式 简化线程（若用一次，且简单）的使用
 * 
 * @author china
 *
 */
public class LambdaThread {

	// 静态内部类
	static class Test implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				System.out.println("一边听歌");
			}
		}
	}

	public static void main(String[] args) {

		new Thread(new Test()).start(); // 匿名方式 start
		System.out.println("main1 ###########");

		// 局部内部类
		class Test2 implements Runnable {
			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println("一边learning");
				}
			}
		}

		new Thread(new Test2()).start();
		System.out.println("main2 ############");

		// 匿名内部类, 必须借助接口或父类
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					System.out.println("一边coding");
				}
			}

		}).start();
		System.out.println("main3 ############");

		// jdk8 简化 lambda。 可用于 简化 简单的线程类。只有一个fn
		new Thread(() -> {
			for (int i = 0; i < 20; i++) {
				System.out.println("一边reading");
			}
		}).start();
		System.out.println("main4 ############");

	}

}
