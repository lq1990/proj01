package cn.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateFormat 完成 字符串和时间对象 作转化
 * @author china
 *
 */
public class TestDateFormat {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss, "
				+ "本年第w周, 本月第W周"); // 设定格式
		
		Date d = new Date(12321314323L);
		String s = df.format(d);
		System.out.println(s);
		
		System.out.println("##############");
		String s2 = "1977-7-7";
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd"); // 设定格式
		try {
			Date d2 = df2.parse(s2);
			System.out.println(d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
