package com.wendao.thread_status;

/**
 * 父亲等待儿子买回来的烟
 * @author china
 *
 */
public class BlockedJoin02 {
	public static void main(String[] args) {
		System.out.println("=== 父亲等待儿子买回来的烟 ===");
		
		new Thread(new Father()).start();
//		new Thread(new Son()).start();
	}
}

class Father extends Thread {
	
	@Override
	public void run() {
		System.out.println("	想抽烟，发现没了，让儿子买烟");
		Thread t = new Thread(new Son());
		t.start();
		try {
			t.join(); // father 被阻塞
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("儿子走丢了");
		}
		System.out.println("	老爸接过烟，把零钱给了儿子");
	}
}

class Son extends Thread {
	
	@Override
	public void run() {
		System.out.println("拿着父亲的钱，去买烟");
		System.out.println("路边有个游戏厅，进去玩了2秒");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("去买烟");
		
	}
}

