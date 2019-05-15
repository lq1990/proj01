package com.wendao.thread_status;

import java.lang.Thread.State;

/**
 * 观察线程的状态
 * @author china
 *
 */
public class AllState {
	public static void main(String[] args) {
		Thread t = new Thread(() ->{
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("...");
		});
		// 观察状态
		System.out.println(t.getState().toString()); // NEW
		
		t.start();
		System.out.println(t.getState().toString()); // RUNNABLE
		
//		while (t.getState() != Thread.State.TERMINATED) {
//			System.out.println("while "+t.getState().toString());
//			
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		while (true) {
			System.out.println("nThreads: "+Thread.activeCount());
			
			if (Thread.activeCount()==1) {
				break;
			}
			
			System.out.println("while "+t.getState().toString());
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
