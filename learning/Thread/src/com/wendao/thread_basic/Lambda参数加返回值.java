package com.wendao.thread_basic;

/**
 * 
 * @author china
 *
 */
public class Lambda参数加返回值 {
	public static void main(String[] args) {
		
		IInterest interest = (int a, int b) -> {
			return a+b;
		};
		System.out.println(interest.lambda(10, 20));
		
		// 简化
		interest = (a,b) -> a+b;
		System.out.println(interest.lambda(1, 4));
		
		
	}
}

interface IInterest {
	int lambda(int a, int b);
}

class Interest implements IInterest {

	@Override
	public int lambda(int a, int b) {
		return 0;
	}
	
}