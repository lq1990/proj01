package com.wendao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.wendao.proj.daoImpl.EmpDaoImpl;
import com.wendao.proj.pojo.Emp;
import com.wendao.proj.serviceImpl.EmpServiceImpl;

public class Test01 {
	
	/**
	 * 	测试入口，
	 * 	main调用service调用 dbImpl 操纵db
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		System.out.println("main test01");
		
		EmpServiceImpl t = new EmpServiceImpl();
		t.update();
		
	}
	
	
	
}
