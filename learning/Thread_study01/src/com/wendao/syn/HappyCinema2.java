package com.wendao.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * 快乐影院。
 * 座位进行选号。
 * 
 * @author china
 *
 */
public class HappyCinema2 {
	public static void main(String[] args) {
		List<Integer> available = new ArrayList<Integer>();
		available.add(1);
		available.add(2);
		available.add(3);
		available.add(6);
		available.add(7);
		
		List<Integer> seats1 = new ArrayList<Integer>();
		seats1.add(1);
		seats1.add(2);
		
		List<Integer> seats2 = new ArrayList<Integer>();
		seats2.add(3);
		seats2.add(7);
		
		Cinema2 c = new Cinema2(available, "Cinema");
		new Thread(new Customer2(c, seats1), "Anna").start();
		new Thread(new Customer2(c, seats2), "Beta").start();
		
	}
}

class Customer2 implements Runnable {
	Cinema2 cinema;
	List<Integer> seats;
	
	/**
	 * @param cinema
	 * @param seats
	 */
	public Customer2(Cinema2 cinema, List<Integer> seats) {
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
						", 预定位子 "+seats);
			} else {
				System.out.println(Thread.currentThread().getName() +" 出票失败 " +  
						", 期望预定 "+seats+", 位子不够");
			}
		}
		
	}
}

class Cinema2 {
	List<Integer> available; // 可用的位置
	String name;

	/**
	 * @param available
	 * @param name
	 */
	public Cinema2(List<Integer> available, String name) {
		super();
		this.available = available;
		this.name = name;
	}
	
	public boolean bookTicket(List<Integer> seats) {
		System.out.println(Thread.currentThread().getName() +" 来订票, 还剩位置: " + 
				this.available);
		List<Integer> copy = new ArrayList<Integer>();
		copy.addAll(available);
		
		// 相减
		copy.removeAll(seats);
		// 判断大小
		if (available.size() - copy.size() != seats.size()) {
			return false;
		}
		
		// 成功
		available = copy;
		return true;
	}
	
	
	
	
}





