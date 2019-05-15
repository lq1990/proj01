package com.wendao.syn;

/**
 * 使用同步块 实现真正的线程安全。
 * 使用同步块，目标更加明确。
 * 
 * @author china
 *
 */
public class SynBlockDrawMoney {
	public static void main(String[] args) {
		// account
		Account account = new Account(1000, "结婚礼金");
		SafeDrawing you = new SafeDrawing(account, 80, "you");
		SafeDrawing wife = new SafeDrawing(account, 90, "wife");
		you.start();
		wife.start();
	}

}

class SafeDrawing extends Thread {
	Account account; // 取钱的账户
	int drawingMoney; // 取的钱数
	int pocketTotal; // 口袋钱总数

	/**
	 * @param account
	 * @param drawingMoney
	 */
	public SafeDrawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
		this.test();
	
	}

	public void test() {
		
		// 提高性能。return了就不必 查看锁了，毕竟查看锁消耗时间。
		if (account.money<=0) {
			return;
		}
		
		// 锁 account
		synchronized (account) {
			if (account.money - drawingMoney < 0) {
				System.out.println(Thread.currentThread().getName() 
						+ " 发现账户余额不足，不能继续操作");
				return;
			} // 发现：即使加了if，也没用。线程依旧不安全

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			account.money -= drawingMoney;
			pocketTotal += drawingMoney;
			System.out.println(this.getName() + ", pocket money: " + this.pocketTotal);
			System.out.println(this.getName() + ", account balance: " + account.money);

		}

	}

}