package com.wendao.class_load_process;

/**
 * self def ClassLoader
 * 
 * @author china
 *
 */
public class ThreadContextCL05 {
	public static void main(String[] args) throws ClassNotFoundException {
		// default AppCL
		ClassLoader loader = ThreadContextCL05.class.getClassLoader();
		System.out.println(loader); 
		
		// 线程上下文类加载器，默认set为AppCL
		ClassLoader loader2 = Thread.currentThread().getContextClassLoader();
		System.out.println(loader2);
		
		// self set
		Thread.currentThread().setContextClassLoader(new FileSystemClassLoader());
		System.out.println(Thread.currentThread().getContextClassLoader());
		
		// bin/ 下面找 class
		Class<Demo02> clz = 
				(Class<Demo02>) Thread.currentThread().getContextClassLoader().loadClass("com.wendao.class_load_process.Demo02");
		System.out.println(clz);
		System.out.println(clz.getClassLoader());
		
	}
}
