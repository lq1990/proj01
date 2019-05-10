package com.wendao.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

/**
 * 对比 加不加 缓冲流 的速度
 * copy InputStream OutputStream
 * 
 * @author china
 *
 */
public class IOTestCopy {
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		copy("pyP1.mp4", "dest.mp4");
		long t2 = System.currentTimeMillis();
		System.out.println("time[ms]: "+(t2-t1)); // 52ms / 16ms
	}

	/**
	 * copy of file
	 * @param srcPath
	 * @param destPath
	 */
	public static void copy(String srcPath, String destPath) {
		// 1. src
		File src = new File(srcPath);
		File dest = new File(destPath);

		// 2. stream
		// try with resource
		try (InputStream is = new BufferedInputStream(new FileInputStream(src)) ;
				OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));)  {
			// 3. read sections
			byte[] flush = new byte[1024];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
//						String str = new String(flush, 0, len);
//						byte[] datas = str.getBytes();
				os.write(flush, 0, len);
			}
			os.flush();

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
