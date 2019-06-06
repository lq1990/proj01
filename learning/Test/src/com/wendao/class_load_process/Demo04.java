package com.wendao.class_load_process;

/**
 * encryption and decryption by using NOT
 * @author china
 *
 */
public class Demo04 {
	public static void main(String[] args) throws Exception {
//		int a = 3; // 00000011
//		System.out.println(Integer.toBinaryString(a^0xff));
//		00000011    3
//		11111111    0xff
//		11111100    ^
		
		EnDecryptClassLoader loader = new EnDecryptClassLoader("D:/myGithub/myJava/learning/Test/src/tmp");
		Class<?> clz = loader.findClass("HelloWorld");
		System.out.println(clz);
		
	}
}
