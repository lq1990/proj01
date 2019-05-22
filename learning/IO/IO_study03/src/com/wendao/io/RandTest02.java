package com.wendao.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.sound.midi.Soundbank;

/**
 * 随机读取和写入流 RandomAccessFile
 * 
 * @author china
 *
 */
public class RandTest02 {
	public static void main(String[] args) throws IOException {
		test03();

	}

	/**
	 * 指定读取的 起始位置
	 * 
	 * @throws IOException
	 */
	public static void test01() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(new File("abc.txt"), "r");
		// random read
		raf.seek(2); // 设置读取的 起始位置

		// operate
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {
//			raf.write(flush, 0, len);
			System.out.println(new String(flush, 0, len));
		}

		raf.close();
	}

	/**
	 * 分块 有起始位置，欲读取的长度
	 * @param i 第几块
	 * @param beginPos 起始位置
	 * @param actualSize 欲读取的长度
	 * @throws IOException
	 */
	public static void split(int i, int beginPos, int actualSize) throws IOException {
		
		RandomAccessFile raf = new RandomAccessFile(
			new File(
				"D:/myGithub/myJava/learning/IO_study03/src/com/wendao/io/CopyTxt.java"), "r");
		
		RandomAccessFile raf2 = new RandomAccessFile(new File("dest/"+i+"copy.java"), "rw");

		// random read
		raf.seek(beginPos);

		// operate
		byte[] flush = new byte[1024];
		int len = -1;
		while ((len = raf.read(flush)) != -1) {
			if (actualSize > len) {
				raf2.write(flush, 0, len);
				actualSize -= len;
			} else {
				raf2.write(flush, 0, actualSize);
				break;
			}
		}
		
		raf.close();
		raf2.close();
	}

	/**
	 * 应该分多少块？
	 * @throws IOException 
	 */
	public static void test03() throws IOException {
		File src = new File("D:/myGithub/myJava/learning/IO_study03/src/com/wendao/io/CopyTxt.java");
		// 总长度
		long len = src.length();

		// 每块大小
		int blockSize = 1024;

		// 多少块
		int size = (int) Math.ceil(len * 1.0 / blockSize);

		System.out.println("num of blocks: "+size);

		// set beginPos
		int beginPos = 0;
		// actualSize 是每次应该取的数目
		int actualSize = (int) (blockSize > len ? len : blockSize);

		for (int i = 0; i < size; i++) {
			beginPos = i * blockSize;
			if (i == size - 1) {
				actualSize = (int) len;
			} else {
				actualSize = blockSize;
				len -= actualSize; 
			}
			System.out.println("\n--------------\n"+
					i+", beginPos:"+beginPos+", actualSize: "+actualSize);
			System.out.println("---------------");
			
			split(i, beginPos, actualSize);
		}

	}
}











