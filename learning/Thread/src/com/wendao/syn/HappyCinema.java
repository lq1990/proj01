package com.wendao.syn;

/**
 * 快乐影院
 * 
 * @author china
 *
 */
public class HappyCinema {
	public static void main(String[] args) {
		Cinema c = new Cinema(10, "Cinema");
		new Thread(new Customer(c, 5), "Anna").start();
		new Thread(new Customer(c, 8), "Beta").start();
		
	}
}

class Customer implements Runnable {
	Cinema cinema;
	int seats;
	
	/**
	 * @param cinema
	 * @param seats
	 */
	public Customer(Cinema cinema, int seats) {
		super();
		this.cinema = cinema;
		this.seats = seats;
	}

	@Override
	public void run() {
		
		synchronized (cinema) {
			boolean flag = cinema.bookTicket(seats);
			
			if (flag) {
				System.out.println(Thread.currentThread().getName() + " 出票成功 " + 
						", 预定位子数量 "+seats);
			} else {
				System.out.println(Thread.currentThread().getName() +" 出票失败 " +  
						", 位子不够");
			}
		}
		
	}
}


class Cinema {
	int available; // 可用的位置
	String name;

	/**
	 * @param available
	 * @param name
	 */
	public Cinema(int available, String name) {
		super();
		this.available = available;
		this.name = name;
	}

	/** 
	 * 同步方法
	 * @param seats
	 * @return
	 */
	public synchronized boolean bookTicket0(int seats) {
		System.out.println(Thread.currentThread().getName() +" 来订票, 还剩位置: " + 
				this.available);
		
		if (seats > available) {
			return false;
		}
		
		available -= seats;
		return true;
	}
	
	public boolean bookTicket(int seats) {
		System.out.println(Thread.currentThread().getName() +" 来订票, 还剩位置: " + 
				this.available);
		
		if (seats > available) {
			return false;
		}
		
		available -= seats;
		return true;
	}
	
	/**
	 * 同步块
	 * @param seats
	 * @return
	 */
	public boolean bookTicket1(int seats) {
		if (seats > available) {
			return false;
		}
		
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() +" 来订票, 还剩位置: " + 
					this.available);
			if (seats > available) {
				return false;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			available -= seats;
			return true;
		}
	}
	
}