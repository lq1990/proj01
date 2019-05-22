package com.wendao.thread_basic;

/**
 * lambda 推导
 * 
 * @author china
 *
 */
public class Lambda推导 {
	static class Like2 implements ILike {
		@Override
		public void lambda() {
			System.out.println("i like lambda2");
		}
	}

	public static void main(String[] args) {
		ILike like = new Like2();
		like.lambda();
		System.out.println("#########");

		like = new ILike() {
			// 匿名内部类，借助 接口或父类 实现
			@Override
			public void lambda() {
				System.out.println("i like lambda3");
			}
		};
		like.lambda();
		System.out.println("##########");
		
		// lambda推导必须存在类型
		ILike like4 = ()->{
			// 接口只能有一个未实现的fn，否则推导不了
			System.out.println("i like lambda4");
		};
		like4.lambda();

	}
}

interface ILike {
	void lambda();
	
	static void well() {
		System.out.println("ddd");
	}

}

class Like implements ILike {

	@Override
	public void lambda() {
		System.out.println("i like lambda");
	}

}