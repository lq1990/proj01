package com.wendaochupin.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/**
 * 1. read img into byte[] 2. byte[] into file
 * 
 * @author china
 *
 */
public class IOTest09 {
	public static void main(String[] args) {
		byte[] datas = fileToByteArray("dog1.jpg");
		System.out.println(datas.length);
		byteArrayToFile(datas, "dest1.jpg");

	}

	/**
	 * read imgs into byte[]
	 * 
	 * 1. img into program, FileInputStream 2. program into byte[], link
	 * ByteArrayOutputStream
	 */
	public static byte[] fileToByteArray(String filePath) {
		// 1. src
		File src = new File(filePath);
		byte[] dest = null; // dest in buf

		// 2. stream
		InputStream is = null;
		ByteArrayOutputStream baos = null;

		try {
			is = new FileInputStream(src);
			baos = new ByteArrayOutputStream();

			byte[] flush = new byte[1];
			int len = -1;
			// 3. read
			while ((len = is.read(flush)) != -1) {
//				String str = new String(flush, 0, len);

				// str 2 byte[]
				baos.write(flush, 0, len);
			}

			baos.flush();

			dest = baos.toByteArray();
//			System.out.println(new String(dest));
			return dest;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != is) {
				try {
					// 4. free
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;

	}

	/**
	 * read byte[] into imgs
	 * 
	 * 1. byte[] in buf into program 2. program into imgs
	 */
	public static void byteArrayToFile(byte[] src, String filePath) {
		// 1. src
//		byte[] src = null;
		File dest = new File(filePath);

		// 2. stream
		InputStream is =null;
		OutputStream os =null;
		try {
			is = new ByteArrayInputStream(src);
			os = new FileOutputStream(dest);

			byte[] flush = new byte[1024];
			int len = -1;
			// 3. read, write
			while ((len = is.read(flush)) != -1) {
				os.write(flush, 0, len);
			}
			os.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null!=os) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
