package com.wendao.thread_basic;

/**
 * 模拟龟兔赛跑
 * 
 * @author china
 *
 */
public class Racer implements Runnable {
	private String winner; // 记录胜利者，此为共享的资源

	@Override
	public void run() {
		for (int step = 1; step <= 100; step++) {
			// 模拟休息
			if ( (step % 10 == 0) && Thread.currentThread().getName().equals("兔子")) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+" --> "+step);
			
			// 比赛是否结束了呢
			boolean flag = gameOver(step);
			if (flag) {
				break;
			}
		}
	}
	
	private boolean gameOver(int step) {
		if (winner != null) { // 存在胜利者
			return true;
		} else {
			if (step == 100) {
				winner = Thread.currentThread().getName();
				System.out.println("winner: " + winner);
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Racer racer = new Racer();// 一个资源 winner
		
		// 多个竞争者
		new Thread(racer, "乌龟").start();
		new Thread(racer, "兔子").start();
	}

}
