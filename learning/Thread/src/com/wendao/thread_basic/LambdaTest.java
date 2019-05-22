package com.wendao.thread_basic;

/**
 * lambda 简化的方式，用于Thread
 * @author china
 *
 */
public class LambdaTest {
	public static void main(String[] args) {
		new Thread(()->{
			System.out.println(Thread.currentThread().getName());
			for(int i=0;i<10;i++) {
				System.out.println(i);
			}
		}).start();
		
		System.out.println(Thread.currentThread().getName());
		
	}
}
