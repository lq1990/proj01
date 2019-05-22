package com.wendaochupin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * InputStream, OutputStream
 * 
 * @author china
 *
 */
public class IOTestCopy02 {
	public static void main(String[] args) {
		copy("dog1.jpg", "dest.jpg");
	}

	public static void copy(String srcPath, String destPath) {
		// 1. src
		File src = new File(srcPath);
		File dest = new File(destPath);

		// 2. stream
		InputStream is = null;
		OutputStream os = null;

		try {
			is = new FileInputStream(src);
			os = new FileOutputStream(dest);

			// 3. read/write
			byte[] flush = new byte[1024];
			int len = -1;
			while ((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);
			}
			os.flush();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. free
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
