package cm.bjsxt.test;

/**
 * test wrapper class
 * @author china
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Integer i = new Integer(11);
		System.out.println(Integer.toHexString(i));
		System.out.println(Integer.MAX_VALUE); // 21亿多
		
		Integer i2 = Integer.parseInt("789");
		System.out.println(i2);
		
		Integer i3 = new Integer("123");
		System.out.println(i3);
		System.out.println(i3.intValue()); // 转成 真正的int
		
		String str = ""+1 +123+"  a";
		System.out.println(str);
	}
}
