package com.wendao.syn;

/**
 * 死锁：过多的同步，可能造成互相不释放资源。
 * 
 * 一般发生于：同时持有多个对象的锁。
 * 
 * @author china
 *
 */
public class DeadLock {

	public static void main(String[] args) {
		Makeup g1 = new Makeup(1, "Anna");
		Makeup g2 = new Makeup(0, "Lina");
		g1.start();
		g2.start();
	}

}

class Lipstick {

}

class Mirror {

}

class Makeup extends Thread {
	// 静态属性。不论多少实例，都是一个口红和一个镜子。
	static Lipstick stick = new Lipstick();
	static Mirror mirror = new Mirror();

	int choice;
	String girl;

	public Makeup(int choice, String girl) {
		super();
		this.choice = choice;
		this.girl = girl;
	}

	@Override
	public void run() {
		// make up
		this.makeup();

	}

	// 互相持有对方的对象锁, 有可能造成 死锁
	private void makeup() {
		if (choice == 0) {
			synchronized (stick) {
				System.out.println(this.girl + "获得口红");
				// 一秒后，想拥有镜子
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				/*
				 * synchronized (mirror) { System.out.println(this.girl+"获得镜子"); }
				 */
			}
			/*
			 * 不要 锁套锁，即可解决死锁的问题。
			 */
			synchronized (mirror) {
				System.out.println(this.girl + "获得镜子");
			}
		} else {
			synchronized (mirror) {
				System.out.println(this.girl + "获得镜子");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
//				synchronized (stick) {
//					System.out.println(this.girl + "获得口红");
//				}
			}
			synchronized (stick) {
				System.out.println(this.girl + "获得口红");
			}
		}

	}
}
