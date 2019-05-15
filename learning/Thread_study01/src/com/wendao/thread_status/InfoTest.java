package com.wendao.thread_status;

/**
 * 其它方法
 * 
 * @author china
 *
 */
public class InfoTest {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().isAlive());
		
		// setName: 真实角色 + 代理角色
		MyInfo info = new MyInfo("战斗机");
		Thread t = new Thread(info); // 线程就是个代理
		t.setName("代理公鸡");
		t.start();
		
		Thread.sleep(1000);
		
		System.out.println(t.isAlive());
	}
}

class MyInfo implements Runnable {
	private String name;
	


	/**
	 * @param name
	 */
	public MyInfo(String name) {
		super();
		this.name = name;
	}



	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" -> "+this.name);
	}
	
}