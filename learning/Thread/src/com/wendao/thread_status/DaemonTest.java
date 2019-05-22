package com.wendao.thread_status;

/**
 * 守护线程：为用户线程服务
 * 默认所有线程都是用户线程，jvm会等待用户线程执行完毕
 * @author china
 *
 */
public class DaemonTest {
	public static void main(String[] args) {
		// 角色
		God god = new God();
		You you = new You();
		
		Thread t = new Thread(god); // 代理
		t.setDaemon(true);// 将t线程有用户线程设置为 Deamon线程
		t.start();
		
		new Thread(you).start();
		
	}
}

class You implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 365*100; i++) {
			System.out.println("you hava a happy life");
		}
		
		System.out.println("......");
	}
}

class God implements Runnable {
	@Override
	public void run() {
		for (;true;) {
			System.out.println("bless you");
		}
	}
}