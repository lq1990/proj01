package com.wendao.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 数据流
 * 1. 写出 后 读取
 * 2. 读取的顺序 与 写出保持一致
 * 
 * DataOutputStream
 * DataInputStream
 * @author china
 *
 */
public class DataTest {
	public static void main(String[] args) throws IOException {
		// write out
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
		/*节点流，都可以加 buffered*/

		// 操作
		dos.writeUTF("编码");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		
		// datas 由 baos而来，而不是 dos。dos只负责按格式写入
		byte[] datas = baos.toByteArray();
		System.out.println(datas.length);
		
		// read
		DataInputStream dis = new DataInputStream(
								new BufferedInputStream(
									new ByteArrayInputStream(datas)));
		
		// 读取顺序要与写入 一致
		String msg = dis.readUTF();
		int age = dis.readInt();
		boolean flag = dis.readBoolean();
		char c = dis.readChar();
		
		System.out.println(msg);
		System.out.println(age);
		System.out.println(flag);
		System.out.println(c);
		
	}
}





