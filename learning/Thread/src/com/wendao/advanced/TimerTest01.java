package com.wendao.advanced;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时调度 Timer, TimerTask
 * 
 * @author china
 *
 */
public class TimerTest01 {
	public static void main(String[] args) {
		System.out.println("main");
		Timer timer = new Timer();
//		timer.schedule(new MyTask(), 2000, 200);
		Calendar cal = new GregorianCalendar(2099, 12, 30, 21, 53, 55);
		timer.schedule(new MyTask(), cal.getTime());

		Thread t = null;
	}
}

class MyTask extends TimerTask {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("take a rest " + i);
		}
	}
}

