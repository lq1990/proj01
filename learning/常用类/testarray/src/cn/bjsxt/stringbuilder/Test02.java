package cn.bjsxt.stringbuilder;

/**
 * test StringBuilder fn
 * @author china
 *
 */
public class Test02 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("abcdefghijk");
		sb.delete(3, 5).delete(3, 5); // [)
		
		System.out.println(sb);
		
		sb.reverse();
		System.out.println(sb);
		
		sb.append("1");
		System.out.println(sb);
	}
}
