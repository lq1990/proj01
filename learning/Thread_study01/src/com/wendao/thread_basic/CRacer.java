package com.wendao.thread_basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 模拟龟兔赛跑
 * 
 * @author china
 *
 */
public class CRacer implements Callable<Integer> {
	private String winner; // 记录胜利者，此为共享的资源

	@Override
	public Integer call() throws Exception {
		for (int step = 1; step <= 100; step++) {
			// 模拟休息
			if ((step % 10 == 0) && Thread.currentThread().getName().equals("pool-1-thread-1")) {
				Thread.sleep(1);
			}
			System.out.println(Thread.currentThread().getName() + " --> " + step);

			// 比赛是否结束了呢
			boolean flag = gameOver(step);
			if (flag) {
				return step;
			}
		}
		return null;
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

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CRacer racer = new CRacer();// 一个资源 winner

		// 1. 创建目标对象
		
		
		// 2. 创建执行服务
		ExecutorService ser = Executors.newFixedThreadPool(2);
		
		// 3. 提交执行
		Future<Integer> res1 = ser.submit(racer);
		Future<Integer> res2 = ser.submit(racer);
		
		// 4. 获取结果
		int r1 = res1.get();
		int r2 = res2.get();
		System.out.println(r2);
		
		// 5. 关闭服务
		ser.shutdownNow();
	}

}
