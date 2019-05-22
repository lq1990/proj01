package com.wendao.syn;

/**
 * 多线程，取钱
 * 
 * @author china
 *
 */
public class UnsafeTest02DrawMoney {
	public static void main(String[] args) {
		// account
		Account account = new Account(100, "结婚礼金");
		Drawing you = new Drawing(account, 80, "you");
		Drawing wife = new Drawing(account, 90, "wife");
		you.start();
		wife.start();
	}
}




