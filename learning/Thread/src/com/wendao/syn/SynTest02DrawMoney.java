package com.wendao.syn;

/**
 * 线程安全，
 * 加同步锁。
 * 但同步锁位置加错了，依然线程不安全。
 * 
 * @author china
 *
 */
public class SynTest02DrawMoney {
	public static void main(String[] args) {
		// account
		Account account = new Account(100, "结婚礼金");
		SafeDrawing you = new SafeDrawing(account, 80, "you");
		SafeDrawing wife = new SafeDrawing(account, 90, "wife");
		you.start();
		wife.start();
	}
	
}

class SafeDrawing0 extends Thread {
	Account account; // 取钱的账户
	int drawingMoney; // 取的钱数
	int pocketTotal; // 口袋钱总数

	/**
	 * @param account
	 * @param drawingMoney
	 */
	public SafeDrawing0(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		this.test();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * synchronized加在此处无用，
	 * 因为同步锁 锁的是this对象提款机。
	 * 应该锁定 Account
	 */
	public synchronized void test() {
		if (account.money - drawingMoney < 0) {
			return;
		} // 发现：即使加了if，也没用。线程依旧不安全
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		account.money -= drawingMoney;
		pocketTotal += drawingMoney;
		System.out.println(this.getName() + ", account balance: " + account.money);
		System.out.println(this.getName() + ", pocket money: " + this.pocketTotal);
	}
	
	
	
	
	
	
	
	
	
	
}