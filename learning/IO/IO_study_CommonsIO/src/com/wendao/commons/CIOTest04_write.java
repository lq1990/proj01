package com.wendao.commons;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * write out
 * @author china
 *
 */
public class CIOTest04_write {
	public static void main(String[] args) throws IOException {
		// 写出文件
		File file = new File("w.txt");
		
		FileUtils.write(file, "happy 开心啊\r\n","UTF-8", false);
		FileUtils.write(file, "happy啊","UTF-8", true);
		FileUtils.writeByteArrayToFile(file, "\r\ndata\r\n".getBytes("utf8"), true);
		
		// 写出列表
		List<String> datas = new ArrayList<String>();
		datas.add("anna");
		datas.add("beta");
		datas.add("cello");
		
		FileUtils.writeLines(file,"utf8", datas,"-", true);
		
		
		
	}
}
