package com.wendao.thread;

import java.util.concurrent.atomic.AtomicLong;
import java.lang.Thread;

/**
 * 使用 CompareAndSwap 的 原子操作，代替 synchronized。 CAS效率高，硬件级别的操作。
 * 
 * 此时，多线程反而慢了。？？？
 * 
 * @author china
 *
 */
public class CAS_Sum {
	static long totalNum = (long) Math.pow(10, 4);

	public static void main(String[] args) throws InterruptedException {
		testSingleNormal();
		System.out.println();
		testSingle();
		System.out.println();
		testMulti();

	}
	
	public static void testSingleNormal() throws InterruptedException {
		// init
		long t1 = System.currentTimeMillis();
		MySumNormal ms1 = new MySumNormal(0, totalNum);
		Thread myt1 = new Thread(ms1);
		myt1.start();
		myt1.join();
		System.out.println(ms1.getRes());
		System.out.println("normal time needed[ms]: " + (System.currentTimeMillis() - t1));
	}

	public static void testSingle() throws InterruptedException {
		// init
		MySumCAS.res = new AtomicLong(0L);
		long t1 = System.currentTimeMillis();
		MySumCAS ms1 = new MySumCAS(0, totalNum);
		Thread myt1 = new Thread(ms1);
		myt1.start();
		myt1.join();
//		System.out.println(ms1.getRes());
		System.out.println(MySumCAS.res.longValue());
		System.out.println("cas single time needed[ms]: " + (System.currentTimeMillis() - t1));
	}

	public static void testMulti() throws InterruptedException {
		// init
		MySumCAS.res = new AtomicLong(0L);
		// 多线程2
		long t11 = System.currentTimeMillis();

		MySumCAS ms11 = new MySumCAS(0, totalNum/2);
		MySumCAS ms12 = new MySumCAS(totalNum/2, totalNum);
		Thread myt11 = new Thread(ms11);
		Thread myt12 = new Thread(ms12);
		myt11.start();
		myt12.start();

		myt11.join();
		myt12.join();

		double res = 0;
//		res += ms11.getRes();
//		res += ms12.getRes();

		res = MySumCAS.res.doubleValue();

		System.out.println(res);
		System.out.println("cas multi time needed[ms]: " + (System.currentTimeMillis() - t11));
	}

}

class MySumCAS implements Runnable {
	long begin;
	long end;
	public static AtomicLong res = new AtomicLong(0L);
//	static double res = 0; // 共享数据

	/**
	 * @param begin
	 * @param end
	 */
	public MySumCAS(long begin, long end) {
		super();
		this.begin = begin;
		this.end = end;
	}

	@Override
	public void run() {
		getSum(begin, end);

	}

	public void getSum(long begin, long end) {
		for (long i = begin; i < end; i++) {
//			res += i;
			for (int j = 0; j < i; j++) {
				res.incrementAndGet();
			}
		}
	}

//	public double getRes() {
//		return res;
//	}

}
class MySumNormal implements Runnable {
	long begin;
	long end;
	double res;
//	static double res = 0; // 共享数据
	
	/**
	 * @param begin
	 * @param end
	 */
	public MySumNormal(long begin, long end) {
		super();
		this.begin = begin;
		this.end = end;
	}
	
	@Override
	public void run() {
		getSum(begin, end);
		
	}
	
	public void getSum(long begin, long end) {
		for (long i = begin; i < end; i++) {
//			res += i;
			for (int j = 0; j < i; j++) {
				res++;
			}
		}
	}
	
	public double getRes() {
		return res;
	}
	
}
