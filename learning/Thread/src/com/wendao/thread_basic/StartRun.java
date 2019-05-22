package com.wendao.thread_basic;

/**
 * 创建线程方式2：
 * 1. implements Runnable, override run()
 * 2. new Thread(p).run()
 * 
 * @author china
 *
 */
public class StartRun implements Runnable {

	@Override
	public void run() {
		for(int i=0; i< 20; i++) {
			System.out.println("一边听歌");
		}
	}
	
	public static void main(String[] args) {
		// 创建实现类对象
//		StartRun sr = new StartRun(); // 由于sr只用一次，可不用声明，用匿名方式替换
		// 创建代理类对象
//		Thread t = new Thread(sr);
//		t.start();
		
		new Thread(new StartRun()).start(); // 匿名方式 start
		
		for(int i=0; i< 20; i++) {
			System.out.println("一边coding");
		}
		
	}

}
