package com.wendao.advanced;

/**
 * 单例模式 懒汉式：多线程下，对外存在一个对象
 * 
 * <p>
 * 1. 构造器私有化：避免外部new实例 <br>
 * 2. 提供私有的静态属性：存储对象的地址  <br>
 * 3. 提供公共的静态方法：获取属性 <br>
 * </p>
 * 
 * @author china
 *
 */
public class DoubleCheckedLocking {

	private volatile static DoubleCheckedLocking instance;// 加volatile，避免指令重排的问题
	// 若没有volatile，其它线程可能会访问到一个 没有初始化的对象
	

	private DoubleCheckedLocking() {
	}

	public static DoubleCheckedLocking getInstance() {

		if (null != instance) { // 当已经有 instance时，直接return
			return instance;
		}

		// 同步块中对象是：类模子
		synchronized (DoubleCheckedLocking.class) {
			if (null == instance) {
				instance = new DoubleCheckedLocking();
				// 1. 开辟空间，2. 初始化对象信息，3. 返回对象的地址给引用
				// 考虑指令重排的问题：JVM可能会直接到第3步，返回null
			}
		}

		return instance;
	}
	
	public static void main(String[] args) {
		System.out.println("main");
		Thread t = new Thread(() ->{
			System.out.println(DoubleCheckedLocking.getInstance());

		});
		t.start();
		
		Thread t1 = new Thread(() ->{
			System.out.println(DoubleCheckedLocking.getInstance());
			
		});
		t1.start();
		
		Thread t12 = new Thread(() ->{
			System.out.println(DoubleCheckedLocking.getInstance());
			
		});
		t12.start();
		Thread t13 = new Thread(() ->{
			System.out.println(DoubleCheckedLocking.getInstance());
			
		});
		t13.start();
		
	}

}









