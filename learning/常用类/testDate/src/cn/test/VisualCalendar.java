package cn.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Visual Calendar
 * 
 * @author china
 *
 */
public class VisualCalendar {
	public static void main(String[] args) {
		System.out.println("input format: yyyy-MM-dd");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		scanner.close();
		
//		String temp = "2019-05-03";
		String temp = input;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date date = df.parse(temp);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);

			int day = calendar.get(Calendar.DAY_OF_MONTH);
			System.out.println("day of week: "+day);
			calendar.set(Calendar.DATE, 1); // 设置到本月的第一天

			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			System.out.println("after set, dayOfWeek: "+ dayOfWeek);
			int maxDate = calendar.getActualMaximum(Calendar.DATE); // 本月 DATE最大数

			System.out.println("日\t一\t二\t三\t四\t五\t六");
			int j = 0;
			for (int i = 1; i <= maxDate; i++) {
				j++;
				if (j < dayOfWeek) {
					System.out.print("\t");
					i--;
					continue;
				}
				if (i == day) {
					System.out.print("*"+i + "*\t");
				} else {
					System.out.print(i + "\t");
				}
				if (j % 7 == 0) {
					System.out.println();
				}
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
