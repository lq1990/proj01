package com.wendao.syn;

/**
 * 线程安全。
 * 目标：在并发时保证数据正确，且效率高
 * 
 * synchronized 1. 同步方法 2. 同步块
 * 
 * @author china
 *
 */
public class SynBlockTicket {

	public static void main(String[] args) {
		// 一份资源
		SafeWeb web = new SafeWeb();
		System.out.println(Thread.currentThread().getName());

		// 多个代理
		new Thread(web, "Anna").start();
		new Thread(web, " Beta").start();
		new Thread(web, "  Cello").start();

	}
}

class SafeWeb implements Runnable {

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
	 * 反面教材。没有锁对。
	 */
	public void test2() {

		// 反面教材。
//		没有锁对，Integer对象地址一直在变，1 2 3 对应的obj不同，锁它没用，线程不安全。
//		应该锁this，this地址不变，this代表大屋子，屋内有属性，线程进屋时要上锁，修改属性后，出门解锁。
		synchronized ((Integer) ticketNums) {
			if (ticketNums <= 0) {
				this.flag = false;
				return;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + ", ticketNums: " + ticketNums--);

		}
	}

	/**
	 * 同步。线程安全. synchronized虽加在了方法上，但实际上是针对的this对象。 线程们会看看 test和实例 有没有上锁。
	 */
	public synchronized void test1() {
		if (ticketNums <= 0) {
			this.flag = false;
			return;
		}

		System.out.println(Thread.currentThread().getName() + ", num: " + ticketNums--);
	}

	
	/**
	 * 双重检测，提高效率。
	 * 主要针对临界值的情况。
	 */
	public void test() {
		// 此处考虑没有票的情况。直接设置flag并return，不必往下执行了。
		if (ticketNums <= 0) { 
			this.flag = false;
			return;
		}
		
		synchronized (this) {
			// 双重检测。
			// 此处考虑剩一张票时。
			if (ticketNums <= 0) { 
				this.flag = false;
				return;
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + ", ticketNums: " + ticketNums--);

		}
	}
}
