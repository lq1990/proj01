package com.wendao.cooperation;

/**
 * 协作模型： 生产者消费者实现方式一：管程法。
 * 
 * @author china
 *
 */
public class CoTest01 {
	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		new Productor(container).start();
		new Consumer(container).start();

	}
}

class Productor extends Thread {
	SynContainer container;

	/**
	 * @param container
	 */
	public Productor(SynContainer container) {
		super();
		this.container = container;
	}

	@Override
	public void run() {
		// 生产
		for (int i = 0; i < 100; i++) {
			System.out.println("生产 ，第 " + i + " 个馒头");
			container.push(new Steamedbun(i));
		}
	}

}

class Consumer extends Thread {
	SynContainer container;

	/**
	 * @param container
	 */
	public Consumer(SynContainer container) {
		super();
		this.container = container;
	}

	@Override
	public void run() {
		// 消费。

		for (int i = 0; i < 500; i++) {
			System.out.println("	消费 ，第 " + container.pop().id + " 个馒头");

		}
	}
}

// 缓冲区
class SynContainer {
	Steamedbun[] buns = new Steamedbun[10]; // container
	int count; // counter

	// 生产
	public synchronized void push(Steamedbun bun) {
		// 何时能生产，容器有空间
		// 不能生产
		if (count == buns.length) {
			try {
				this.wait();// 等待 消费者通知。
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 有空间，可以生成
		buns[count++] = bun;
		// 存在数据了，可以消费了
		this.notifyAll();
	}

	// 消费 判断容器中是否有数据。缓冲区数据没有先后之分，随便消费者拿。
	// 没有数据，只有等待
	public synchronized Steamedbun pop() {
		if (count == 0) {
			try {
				this.wait(); // 线性阻塞，等待 被通知 才能解除阻塞
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		count--;
		Steamedbun bun = buns[count];
		this.notifyAll(); // 此时缓冲区有剩余空间，通知生产者
		return bun;
	}

}

// 馒头
class Steamedbun {
	int id;

	/**
	 * @param id
	 */
	public Steamedbun(int id) {
		super();
		this.id = id;
	}

}
