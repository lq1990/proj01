package com.wendao.thread_status;

/**
 * sleep 模拟网络延时，放大了发生问题的可能性
 * @author china
 *
 */
public class BlockedSleep01 {
	public static void main(String[] args)  {
		// 一份资源
		Web12306 web  = new Web12306(); 
		System.out.println(Thread.currentThread().getName());
		
		// 多个代理
		new Thread(web, "Anna").start();
		new Thread(web, " Beta").start();
		new Thread(web, "  Cello").start();
		
	}
	
}


class Web12306 implements Runnable {

	private int ticketNums = 30; // 票数

	@Override
	public void run() {
		while (true) {
			if (ticketNums < 0) {
				break;
			}
			
			try {
				Thread.sleep(100); // 使用sleep， 放大错误
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+
					", num: "+ticketNums--);
		}
	}

	 
}









