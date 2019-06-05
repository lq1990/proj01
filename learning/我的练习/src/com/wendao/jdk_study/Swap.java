package com.wendao.jdk_study;

import java.lang.reflect.Field;

import org.omg.CORBA.portable.ValueOutputStream;

public class Swap {
	public static void main(String[] args) {
		Integer a = 1111;
		Integer b = 2222;
		System.out.println("a: "+a+", b: "+b);
		
		// TODO

		swap_learn(a, b);
		System.out.println("a: "+a+", b: "+b);
		
		
	}
	
	/**
	 *	这样写终究不好 
	 * @param a
	 * @param b
	 */
	private static void swap(Integer a, Integer b) {
		MySwap aa = new MySwap(a);
		MySwap bb = new MySwap(b);
		swap0(aa, bb);
		a = (Integer) aa.getVal();
		b = (Integer) bb.getVal();
		
		System.out.println("a: "+a+", b: "+b);
		System.exit(0);
	};
	
	private static void swap0(MySwap n1, MySwap n2) {
//		System.out.println(n1.getVal()+", "+n2.getVal());
		
		MySwap tmp = new MySwap(n1.getVal());
		n1.setVal(n2.getVal());
		n2.setVal(tmp.getVal());
		
//		System.out.println(n1.getVal()+", "+n2.getVal());
		
//		System.out.println(num1 +", "+ num2);
		
	}
	
	static class MySwap {
		private Object val;
		
		public MySwap(Object val) {
			this.val = val;
		}

		public Object getVal() {
			return val;
		}

		public void setVal(Object val) {
			this.val = val;
		}

	}
	
	private static void swap_learn(Integer num1, Integer num2) {
		// 下面这样写，不能实现。因为num1、num2是a b的拷贝。num1 num2变了，但a b不变
		Integer tmp = new Integer(num1);
		num1 = num2; // 只是把num2的地址给了num1
		num2 = tmp;
		
		// 试试利用 装箱拆箱的特性
//		int val1 = (Integer)num1;
//		int val2 = (Integer)num2;
//		
//		num1 = (Integer)val2;
//		num2 = Integer.valueOf(val1);
//		
//		System.out.println((Integer)num1+", "+(Integer)num2);
//		System.out.println(num1+", "+num2);
		
		// 使用反射
//		try {
//			// 属性
//			Field field = Integer.class.getDeclaredField("value");
//			field.setAccessible(true);
//			
//			int tmp = num1.intValue(); // tmp为简单类型，不受引用影响
//			System.out.println("tmp: "+tmp+", Integer: "+ (Integer)tmp); 
//			field.setInt(num1, num2); // num1改变了，tmp也会改变
////			field.setInt(num2, tmp); // tmp为num1的地址
////			或
//			field.set(num2, new Integer(tmp)); // new的话 将int的值变成obj。 若不new Integer，自动装箱 tmp是引用，值已变
//			
//			System.out.println("tmp: "+tmp+", Integer: "+ (Integer)tmp); // 11, 22
//			// tmp没有装箱，值不变。
////			若将tmp改为Integer，则num2会是引用值，此时引用值已经被num1改了
//			
//			// 简单说，int tmp存储的值不会随引用变。
//			// 但：Integer tmp会变
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
		
	}
}
