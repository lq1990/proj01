package com.wendao.advanced;

/**
 * volatile用于保证数据的同步，数据可见性
 * @author china
 *
 */
public class VolatileTest {
	
	private volatile static int num =0;
	
	public static void main(String[] args) {
		System.out.println("main...");
		
		new Thread(() ->{
			while (num==0) {
				
			}
			System.out.println(Thread.currentThread().getName()+" stops");
		}).start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		num = 1; // main 线程中修改 num
		System.out.println(num);
	}
}
