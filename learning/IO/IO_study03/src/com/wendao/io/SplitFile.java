package com.wendao.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * RandomAccessFile
 * 
 * SequenceStream
 * 
 * @author china
 *
 */
public class SplitFile {

	public static void main(String[] args) throws IOException {
//		SplitFile sf = new SplitFile("dog1.jpg", "dest", 1024*10);
		SplitFile sf = new SplitFile("dog1.jpg", "dest");
		sf.split();
		sf.merge("merge1.jpg");

	}

	private File src; // 源头

	private String destDir; // 目的地（文件夹）

	private List<String> destPaths; // 所有分割后的文件存储路径

	private int blockSize; // 每块大小

	private int size; // 块数

	public SplitFile() {
		super();
	}

	/**
	 * 在构造器内 调用其他构造器
	 * 
	 * @param srcPath
	 * @param destDir
	 */
	public SplitFile(String srcPath, String destDir) {
		this(srcPath, destDir, 1024 * 10);
	}

	public SplitFile(String srcPath, String destDir, int blockSize) {
		super();
		this.src = new File(srcPath);
		this.destDir = destDir;
		this.blockSize = blockSize;
		this.destPaths = new ArrayList<String>();

		// init
		init();

	}

	private void init() {
		long len = src.length();
		this.size = (int) Math.ceil(len * 1.0 / blockSize);

		// path
		for (int i = 0; i < size; i++) {
			this.destPaths.add(this.destDir + "/" + i + "-" + this.src.getName());
		}
	}

	/**
	 * split 1. 计算每一块的起始位置及大小 2. 分割
	 * 
	 * @throws IOException
	 */
	public void split() throws IOException {
		long len = src.length();
		int beginPos = 0;
		int actualSize = (int) (blockSize > len ? len : blockSize);
		for (int i = 0; i < size; i++) {
			beginPos = i * blockSize;
			if (i == size - 1) {
				actualSize = (int) len;
			} else {
				actualSize = blockSize;
				len -= actualSize;
			}

			splitDetail(i, beginPos, actualSize);

		}

	}

	private void splitDetail(int i, int beginPos, int actualSize) throws IOException {

		RandomAccessFile raf = new RandomAccessFile(this.src, "r");

		RandomAccessFile raf2 = new RandomAccessFile(new File(this.destPaths.get(i)), "rw");

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

	public void merge(String destPath) throws IOException {
		// 输出流
		OutputStream os 
			= new BufferedOutputStream(
				new FileOutputStream(destPath, true/*append*/));

		Vector<InputStream> vi  = new Vector<InputStream>();
		SequenceInputStream sis = null;
		
		
		// 输入流
		for (int i = 0; i < destPaths.size(); i++) {
			vi.add(
				new BufferedInputStream(
					new FileInputStream(destPaths.get(i))));
		}
		
		sis = new SequenceInputStream(vi.elements());
		
		// copy
		int len=-1;
		byte[] flush= new byte[1024];
		while((len = sis.read(flush))!=-1) {
			os.write(flush, 0, len);
		}
		
		os.flush();
		sis.close();
		os.close();
	}
}











