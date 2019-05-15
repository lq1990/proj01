package com.wendao.thread;

/**
 * 
 * @author china
 *
 */
public class Sum0 {


	public double sum(long start, long end) {
		double tmp = 0;
		for (long i = start; i < end; i++) {
			tmp += i;
		}
		return tmp;
	}
}
