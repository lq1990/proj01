package com.wendao.class_load_process;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义 文件系统类加载器
 * 
 * @author china
 *
 */
public class FileSystemClassLoader0 extends ClassLoader {

//	com.wendao.User --> d:/xxx/   com/wendao/User.class
	private String rootDir; // D:/myGithub/myJava/learning/Test/src/

	public FileSystemClassLoader0(String rootDir) {
		this.rootDir = rootDir;

	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {

		Class<?> c = findLoadedClass(name);
		
		// 应先查询是否已经加载了这个类
		if (null != c) {
			return c;
		} else {
			// 若没被加载过，先让父类加载
			ClassLoader parent = this.getParent();
			c = parent.loadClass(name); // 委派给父类加载
			if (null != c) {
				return c;
			} else {
				byte[] classData = getClassData(name);
				if (null == classData) {
					throw new ClassNotFoundException();
				} else {
					// define a class
					c = defineClass(name, classData, 0, classData.length);
				}
			}
			
		}
		
		return c;
	}
	
	private byte[] getClassData(String classname) {
		String path = this.rootDir + "/"  + classname.replace('.', '/') + ".class";
		// 转换为 字节数组
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			is = new FileInputStream("path");
			baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = is.read(buffer))!=-1) {
				baos.write(buffer, 0, len); // 将字节数组数据 写入到 baos
			}
			return baos.toByteArray();
			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (null != baos) {
				// 字节流，可以不用人为关闭
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
//	public static void main(String[] args) {
//		String str = "com.wendao.learn.Clz";
//		System.out.println(str.replace('.', '/')+".class");
//	}

}












