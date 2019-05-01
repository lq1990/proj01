package cn.bjsxt.stringbuilder;

/**
 * String 不可变字符序列. 
 * StringBuilder 是可变字符序列，线程不安全 效率高.
 *  StringBuffer 和StringBuilder类似，线程安全 但效率低，
 *  
 *  动态数组会扩容。实质上是建立 一个更大的数组，将原数据拷贝到其上
 * 
 * @author china
 *
 */
public class Test01 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(); // 默认的 字符数组长度 16

		StringBuilder sb1 = new StringBuilder(32); // 设置 字符数组长度为32
		StringBuilder sb2 = new StringBuilder("abcd");
		sb2.append("efg");
		sb2.append(true).append(false).append('z');
		System.out.println(sb2);

		System.out.println("############");
		StringBuilder gh = new StringBuilder("a");
		for (int i = 0; i < 20; i++) {
			gh.append(i);
		}
		System.out.println(gh);

	}
}
