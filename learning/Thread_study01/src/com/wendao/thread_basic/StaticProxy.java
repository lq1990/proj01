package com.wendao.thread_basic;

/**
 * 静态代理
 * 1. 真实角色
 * 2. 代理角色
 * @author china
 *
 */
public class StaticProxy {
	public static void main(String[] args) {
		new WeddingCompany(new You()).happyMarry();
	}
}

interface Marry{
	void happyMarry();
}

class You implements Marry{

	@Override
	public void happyMarry() {
		System.out.println("You and Change get married!");
	}
	
}

// proxy
class WeddingCompany implements Marry {
	// 真实角色
	private Marry target;
	
	/**
	 * @param target
	 */
	public WeddingCompany(Marry target) {
		super();
		this.target = target;
	}

	@Override
	public void happyMarry() {
		ready();
		this.target.happyMarry();
		after();
	}
	
	private void ready() {
		System.out.println("ready...");
	}
	
	private void after() {
		System.out.println("闹洞房");
	}
	
}
