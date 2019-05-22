package com.wendaochupin.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * free 
 * try...with...resource
 * encapsulate 1. copy 2. free
 * 
 * @author china
 *
 */
public class FileUtils2 {
	public static void main(String[] args) {
		// file 2 file
		try {
			InputStream is = new FileInputStream("abc.txt");
			OutputStream os = new FileOutputStream("dest1523.txt");
			copy(is, os);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// file 2 byte[]
		try {
			InputStream is = new FileInputStream("dog1.jpg");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			copy(is, os);

			byte[] datas = os.toByteArray();
			System.out.println(datas.length);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// byte[] 2 file
		try {
			byte[] buf = "buf datas".getBytes();
			InputStream is = new ByteArrayInputStream(buf);
			OutputStream os = new FileOutputStream("buf.txt");
			copy(is, os);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param is
	 * @param os
	 */
	public static void copy(InputStream is, OutputStream os) {
		try(is;os){
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
		} 
	}

	

}



















