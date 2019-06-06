package com.wendao.class_load_process;

/**
 * test defined FileSystemClassLoader
 * @author china
 *
 */
public class Demo03 {
	public static void main(String[] args) throws ClassNotFoundException {
		FileSystemClassLoader loader = new FileSystemClassLoader("D:/myGithub/myJava/learning/Test/src");
		FileSystemClassLoader loader2 = new FileSystemClassLoader("D:/myGithub/myJava/learning/Test/src");
		
		Class clz = loader.loadClass("com.wendao.HelloWorld");
		System.out.println(clz.hashCode()+", "+clz.getClassLoader());
		Class clz2 = loader.loadClass("com.wendao.HelloWorld");
		System.out.println(clz2.hashCode()+", "+clz.getClassLoader());
		
		// 不同的类加载器 加载 同一个class，JVM认为是不同的class。
		Class clz3 = loader2.loadClass("com.wendao.HelloWorld");
		System.out.println(clz3.hashCode()+", "+clz3.getClassLoader());
		
		Class clz4 = loader2.loadClass("java.lang.String");
		System.out.println(clz4.hashCode()+", "+clz4.getClassLoader()); // clz4 use Bootstrap classloader
		
		Class clz5 = loader2.loadClass("com.wendao.class_load_process.Demo01");
		System.out.println(clz5.hashCode()+", "+clz5.getClassLoader()); // App CL

	}
}
