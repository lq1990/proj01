package com.wendao.syn;


/**
 * 线程安全: 在并发时保证数据正确，且效率高
 * 
 * synchronized
 * 1. 同步方法
 * 2. 同步块
 * 
 * @author china
 *
 */
public class SynTest01Ticket {

	public static void main(String[] args) {
		// 一份资源
		SafeWeb12306 web = new SafeWeb12306();
		System.out.println(Thread.currentThread().getName());

		// 多个代理
		new Thread(web, "Anna").start();
		new Thread(web, " Beta").start();
		new Thread(web, "  Cello").start();

	}
}

class SafeWeb12306 implements Runnable {

	private int ticketNums = 10; // 票数
	private boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			test();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 同步。线程安全.
	 * synchronized虽加在了方法上，但实际上是针对的this对象。
	 * 线程们会看看 test和实例 有没有上锁。
	 */
	public synchronized void test() {
		if (ticketNums <= 0) {
			this.flag = false;
			return;
		}
		
		System.out.println(Thread.currentThread().getName() + 
				", num: " + ticketNums--);
	}

}