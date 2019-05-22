package com.wendao.cooperation;

/**
 * 信号灯，解决线程间通信
 * 
 * @author china
 *
 */
public class CoTest02 {
	public static void main(String[] args) {
		TV tv = new TV();
		new Player(tv).start();
		new Watcher(tv).start();

	}
}

class Player extends Thread {
	TV tv;

	/**
	 * @param tv
	 */
	public Player(TV tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0) {
				this.tv.play("奇葩说");
			} else {
				this.tv.play("太污了啊");
			}
		}
	}
}

class Watcher extends Thread {
	TV tv;

	/**
	 * @param tv
	 */
	public Watcher(TV tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			tv.watch();
		}
	}

}

class TV {
	String voice;
	boolean flag = true; // true: 演员表演 观众等待，false：观众观看 演员等待

	public synchronized void play(String voice) {
		// 演员等待
		System.out.println("		in play");
		if (!flag) {
			try {
				System.out.println("play wait...");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.voice = voice;
		System.out.println("表演了: " + this.voice);

		// 唤醒
		this.notifyAll(); 
		// 此时，锁还在 play里，继续play下面的，直到同步块结束。
		this.flag = !this.flag; 
		System.out.println("play flag: "+this.flag);
	}

	public synchronized void watch() {
		System.out.println("			in watch");
		// 观众等待
		if (flag) {
			try {
				System.out.println("watch wait......");
				this.wait(); // wait 会释放锁。等待被通知
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("听到了: " + this.voice);
		// 唤醒
		this.notifyAll();
		this.flag = !this.flag;
		System.out.println("watch flag: "+this.flag);

	}

}
