package com.wendao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Demo03baos_toString {
	public static void main(String[] args) throws IOException {
		String str = "我喜欢学习";
		ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("gbk"));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int tmp = 0;
		while((tmp = bis.read())!=-1) {
			bos.write(tmp);
		}
		bos.flush();
		
		System.out.println(bos.toString("gbk"));
		
	}
}
