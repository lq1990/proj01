package com.wendao.thread_basic;

/**
 * 
 * @author china
 *
 */
public class Lambda加参数 {
	public static void main(String[] args) {
		// love会根据接口中 未被实现的方法 进行推导
		ILove love = (int a)->{
			System.out.println("content: "+a);
		};
		love.lambda(111);
		
		// 简化
		love = (a)->{
			System.out.println("content: "+a);
		};
		love.lambda(123);
		
		// 继续，若只有一个参数，括号也可以省略
		love = a->{
			System.out.println("content: "+a);
		};
		love.lambda(333);
		
		// 继续
		love = a -> System.out.println("content: "+a);
		love.lambda(909090);
		
	}
	
}

interface ILove{
	void lambda(int a);
}