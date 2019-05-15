package com.wendao.thread;

public class Client {
	public static void main(String[] args) throws InterruptedException {

		long totalNum = 2000000000L;
		
		testSingleThread(0, totalNum);
		System.out.println();
		testMultiThread(0, totalNum);

//		System.out.println(MySum.res);
//		System.out.println("client: "+ms.getRes()); // 0 此时新的线程还未计算完
//		System.out.println("client: "+ms.getRes()); // 4950 计算结果出来了
//		System.out.println("client: "+ms.getRes());
//		System.out.println("client: "+ms.getRes());
//		System.out.println("client: "+ms.getRes());


	}

	private static void testSingleThread(long begin, long end) throws InterruptedException {
		long t0 = System.currentTimeMillis();
		MySum ms = new MySum(begin, end);
		Thread t1 = new Thread(ms);
		t1.start();
		t1.join();

		System.out.println("single thread, res: "+ms.getRes());

		System.out.println("time needed[ms]: " + 
				(System.currentTimeMillis() - t0));
	}
	
	private static void testMultiThread(long begin, long end) throws InterruptedException {
		long t0 = System.currentTimeMillis();
		
		MySum ms1 = new MySum(begin, end/3);
		MySum ms2 = new MySum(end/3, end/3*2);
		MySum ms3 = new MySum(end/3*2, end);
		Thread t1 = new Thread(ms1);
		Thread t2 = new Thread(ms2);
		Thread t3 = new Thread(ms3);
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
		
		double res = 0;
		res += ms1.getRes();
		res += ms2.getRes();
		res += ms3.getRes();
		
		System.out.println("multi-thread, res: " + res);
		System.out.println("time needed[ms]: " + 
				(System.currentTimeMillis() - t0));
		
		
	}
}
