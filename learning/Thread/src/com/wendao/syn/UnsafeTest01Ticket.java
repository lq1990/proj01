package com.wendao.syn;


/**
 * 线程不安全
 * @author china
 *
 */
public class UnsafeTest01Ticket {

	public static void main(String[] args) {
		// 一份资源
		UnsafeWeb12306 web = new UnsafeWeb12306();
		System.out.println(Thread.currentThread().getName());

		// 多个代理
		new Thread(web, "Anna").start();
		new Thread(web, " Beta").start();
		new Thread(web, "  Cello").start();

	}
}

class UnsafeWeb12306 implements Runnable {

	private int ticketNums = 10; // 票数
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			test();
		}
	}
	
	public void test() {
		if (ticketNums <= 0) {
			this.flag = false;
			return;
		}
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + 
				", num: " + ticketNums--);
	}

}