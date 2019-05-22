package com.wendao.thread_basic;

/**
 * �����߳�
 * ��ʽ1�� extends Thread, override, start
 * 
 * @author china
 *
 */
public class StartThread extends Thread {
	
	/**
	 * �߳���ڵ�
	 */
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			System.out.println("һ������");
		}
		
	}
	
	public static void main(String[] args) {
		// new���� start �����߳�
		StartThread st = new StartThread();
		st.start(); // start�� ����һ���߳�
//		st.run(); // ���� ��ͨ�����ĵ���
		
		for(int i=0;i<20;i++) {
			System.out.println("һ��coding");
		}
	}
}
