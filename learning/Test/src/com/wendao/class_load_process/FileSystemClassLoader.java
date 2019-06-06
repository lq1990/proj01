package com.wendao.class_load_process;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * self define a ClassLoader
 * 
 * load a .class in a dir
 * 
 * @author china
 *
 */
public class FileSystemClassLoader extends ClassLoader {
	// com.xxx.test.User --> d:/xxx/ com/xxx/test/User.class
	private String rootDir;

	public FileSystemClassLoader() {
	}

	/**
	 * @param rootDir
	 */
	public FileSystemClassLoader(String rootDir) {
		super();
		this.rootDir = rootDir;
	}

	@Override
	public Class<?> findClass(String name) throws ClassNotFoundException {
		Class<?> c = findLoadedClass(name);
		// 1. check if loaded
		if (null != c) {
			System.out.println("已被加载，直接返回");
			return c;
		} else {
			ClassLoader parent = this.getParent(); // app classloader
			try {
				c = parent.loadClass(name); // entrust parent to do
			} catch(Exception e) {
//				e.printStackTrace();
			}
			
			if (null != c) {
				return c;
			} else {
				// parent cannot load, so do it by myself
				byte[] classData = getClassData(name); // get byte array
				if (classData == null) {
					throw new ClassNotFoundException();
				} else {
					c = defineClass(name, classData, 0, classData.length);
					return c;
				}
			}
		}
	}

	/**
	 * 
	 * @param classname eg. com.xxx.test.User --> d:/xxx/ com/xxx/test/User.class
	 * @return
	 */
	private byte[] getClassData(String classname) {
		// 1. src
		String path = rootDir + "/" + classname.replace('.', '/') + ".class";
		// 2. InputStream/OutputStream to convert .class into byte[]
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try {
			is = new FileInputStream(path);
			baos = new ByteArrayOutputStream();
			// 3. read
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			baos.flush();
			return baos.toByteArray();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. close
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// bytearray 不须手动close
		}

		return null;
	}
//
//	public static void main(String[] args) {
//		System.out.println(System.getProperty("user.dir"));
//	}

}
