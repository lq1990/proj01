package com.wendao.my_server;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭流的方法
 * @author china
 *
 */
public class CloseUtil {
	public static void closeAll(Closeable... io /*可变长参数*/) {
		for(Closeable item : io) {
			if (null != item) {
				try {
					item.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
