package com.wendao.dynamic_compile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class Demo01 {
	public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		// =========== 1.1 动态编译一个本地文件 ===========
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//		int result = compiler.run(null, null, null, "D:\\myGithub\\myJava\\learning\\Test\\src\\HelloWorld.java");
//		System.out.println(result==0 ? "编译成功" : "编译失败");
		// Window-Preferences--Java-installed JREs-Edit-add external jars 设置
		
		// ========== 1.2. 动态编译一个String ==============
		String str = "public class Hi {"
				+ "\r\n"
				+ "public static void main(String[] args) {"
				+ "\r\n"
				+ "System.out.println(\"Hi Hi, I am LQ.\");"
				+ "\r\n"
				+ "}"
				+ "}";
		
		// 通过IO流操作，将字符串存储为一个 "xx.java"临时文件，然后调用动态编译方法
		String destPath = "D:\\myGithub\\myJava\\learning\\Test\\src\\Hi.java";
		File dest = new File(destPath);// 1. src/dest
		OutputStream os = null;// 2. stream
		os = new FileOutputStream(dest);
		os.write(str.getBytes(), 0, str.getBytes().length);// 3. read/write flush
		os.flush();
		os.close();// 4. close
		
		// compile
		int res2 = compiler.run(null, null, null, destPath);
		System.out.println("res2(0:success): "+res2);
		System.out.println();
		
		// ====== 2.1 编译后需要运行。启动新的进程去运行 ============
//		Runtime run = Runtime.getRuntime();
//		Process process = run.exec("java -cp D:/myGithub/myJava/learning/Test/src Hi");
//		InputStream is = process.getInputStream();
//		BufferedReader br = new BufferedReader(new InputStreamReader(is));
//		String line = null;
//		while( (line = br.readLine()) != null ) {
//			System.out.println(line);
//		}
//		
//		is.close();
//		
//		System.out.println();
		// ============= 2.2 运行。用类加载器 ======================
		URL[] urls = new URL[] {new URL("file:/"+"D:/myGithub/myJava/learning/Test/src/")};
		URLClassLoader loader = new URLClassLoader(urls);
		Class c = loader.loadClass("Hi");
		// 调用加载类的main方法
		c.getMethod("main", String[].class).invoke(null, (Object)new String[] {});
									// obj=null，因为main为static方法，无需通过对象来调用
									// 而第二个必须强制转型为Object，否则String会被拆成多个str
		
		
		
		
		
		
		
	}
}











