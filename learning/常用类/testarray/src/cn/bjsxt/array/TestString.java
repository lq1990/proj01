package cn.bjsxt.array;

public class TestString {
	public static void main(String[] args) {
		String str = "abcd";

		System.out.println(str.charAt(1));

		String str3 = "defef";
		String str4 = "def";
		System.out.println(str3);
		System.out.println(str4);
		System.out.println(str3 == str4);

		System.out.println(str3.indexOf("ee"));
		System.out.println(str3.substring(1));

		System.out.println("######## replace");
		str3 = str3.replace('e', '*'); // replace
		System.out.println(str3);

		System.out.println("########");
		String str6 = "abcd,jkj,feaf";
		String[] strArray = str6.split(","); // split，返回 字符串数组
		for (String item : strArray) {
			System.out.println(item);
		}

		String str7 = "  ajkjk  kjkjs  ";
		String str77 = str7.trim(); // trim 去除首尾空格
		System.out.println(str77);

		System.out.println("#############");
		char[] str7_charArr = str7.toCharArray(); // toCharArray
		System.out.println(str7_charArr[3]);

		System.out.println("###########");
		System.out.println("Abc".equalsIgnoreCase("abc"));

		System.out.println("Abcbd".indexOf('b'));
		System.out.println("Abcbd".lastIndexOf('b'));
		System.out.println("Abcbd".startsWith("Ab"));

		String s1 = "Abcbd";
		System.out.println(s1);
		String s1Upper = s1.toUpperCase();
		System.out.println(s1);
		System.out.println(s1Upper);

		String gh = "a"; // "a"是不可变字符序列，但gh不是final 故可变
		for (int i = 0; i < 10; i++) {
			gh += i;
		}
		System.out.println(gh);
	}

}
