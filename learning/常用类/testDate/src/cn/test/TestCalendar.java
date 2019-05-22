package cn.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 测试 日历类、即日期类
 * 
 * @author china
 *
 */
public class TestCalendar {
	public static void main(String[] args) {
		Calendar c = new GregorianCalendar();
//		c.set(2001, Calendar.FEBRUARY, 10, 12, 23, 34);
		
		// 一个个设置
//		c.set(Calendar.YEAR, 2001);
//		c.set(Calendar.MONTH, Calendar.FEBRUARY);
//		c.set(Calendar.DATE, 10);
		
//		c.setTime(new Date());
		
		
		Date d = c.getTime();
		System.out.println(d);
		System.out.println(c.get(Calendar.YEAR));
		
		// 日期计算
		c.add(Calendar.MONTH, -30);
		System.out.println(c.getTime());
	}
}
