package com.wendao.thread;

/**
 * use multi-thread to sum and compare with single-thread
 * 
 * @author china
 *
 */
public class MySum implements Runnable {
	private long start;
	private long end;
	private double res;
	
	public MySum(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		Sum0 s = new Sum0();
		res = s.sum(start, end);
	}
	
	public double getRes() {
//		System.out.println("MySum getRes: "+res);
		return res;
	}
}
