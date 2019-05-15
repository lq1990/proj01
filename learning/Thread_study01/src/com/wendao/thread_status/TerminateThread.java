package com.wendao.thread_status;

import java.util.Iterator;

/**
 * 
 * 终止线程方式：
 * 
 * 1. 正常执行完毕
 * 
 * 2. 外部干涉，加入标识
 * 
 * 不要用stop
 * 
 * @author china
 *
 */
public class TerminateThread implements Runnable {
	private boolean flag = true; // 1. 标识，false时线程终止
	private String name;

	public static void main(String[] args) {
		TerminateThread tt = new TerminateThread("Anna");
		new Thread(tt).start();

		for (int i = 0; i < 99; i++) {
			System.out.println("main " + i);

			if (i == 88) {
				tt.terminate();
				System.out.println("--- tt game over ---");
			}

		}
	}

	/**
	 * @param name
	 */
	public TerminateThread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		int i = 0;
		// 2. 关联标识
		while (flag) {
			System.out.println(name + "-->" + i++);
		}
	}

	// 3. 对外提供方法 改变标识
	public void terminate() {
		this.flag = false;
	}

}
