package com.wendao.syn;


//模拟取款
public class Drawing extends Thread {
	Account account; // 取钱的账户
	int drawingMoney; // 取的钱数
	int pocketTotal; // 口袋钱总数

	/**
	 * @param account
	 * @param drawingMoney
	 */
	public Drawing(Account account, int drawingMoney, String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}

	@Override
	public void run() {
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
