package com.wendao.syn;

public class Happy {
	public static void main(String[] args) {
		Web w = new Web(10, "A");
		
		new Passenger(w, "Anna", 4).start();
		new Passenger(w, "Beta", 9).start();
	}
}

class Passenger extends Thread {
	int seats;
	
	public Passenger(Runnable target, String name, int seats) {
		super(target, name);
		this.seats = seats;
	}
	
}

class Web implements Runnable {
	int available;
	String name;
	
	
	/**
	 * @param available
	 * @param name
	 */
	public Web(int available, String name) {
		super();
		this.available = available;
		this.name = name;
	}



	@Override
	public void run() {
		// 谁run这个，就是谁。因为 Passenger调用这个run，所以强转为P
		System.out.println(Thread.currentThread().getName()+" use...");
		Passenger p = (Passenger)Thread.currentThread();
		boolean flag = this.book(p.seats);
		if (flag) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
	
	public synchronized boolean book(int seats) {
		if (seats > available) {
			return false;
		}
		
		available -= seats;
		return true;
	}
}
















