package com.wendao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wendao.mapper.LogMapper;
import com.wendao.pojo.Log;

public class Test2 {

	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession ss = fac.openSession();
		
		// console
		Scanner input = new Scanner(System.in);
		System.out.println("请输入转账账号：");
		String accout = input.nextLine();
		System.out.println("请输入收款账号：");
		String accin = input.nextLine();
		
		LogMapper mapper = ss.getMapper(LogMapper.class);
		
//		List<Log> list = mapper.selByAccInAccOut(accin, accout);
//		System.out.println(list);
		
		// ------------------- update ---------------
//		Log log = new Log();
//		log.setId(1); // 设置要修改的记录的id
//		log.setAccOut(accout);
//		log.setAccIn(accin);
//		int index = mapper.upd(log);
//		System.out.println("index: "+index);
		
		// -------------- selByLog --------------
//		Log log = new Log();
//		log.setAccIn("101");
//		List<Log> list = mapper.selByLog(log);
//		System.out.println(list);
		
		// ---------- upd, trim --------------
//		Log log = new Log();
//		log.setMoney(999);
//		int index = mapper.upd(log);
//		System.out.println("index: "+index);
		
		 // ------------ bind -------------
//		Log log = new Log();
//		log.setMoney(555);
//		List<Log> list = mapper.selByLog(log);
		
		// ---------------- foreach, in (,,,) --------------
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(3);
//		list.add(2);
//		List<Log> list2 = mapper.selIn(list); // select * from log where id in (?,?);
//		
//		System.out.println(list2);
		
		
		// ------------ foreach, insert into log values (),(),() -----------
//		List<Integer> list = new ArrayList<Integer>();
//		for(int i=0; i<3;i++) {
//			list.add(i);
//		}
//		Integer idx = mapper.insMany(list);
//		System.out.println("index: "+idx);
		
		// -------------- sql, ref ------------
		List<Log> list = mapper.selUsingRef();
		System.out.println(list);
		
		
		ss.commit();
		ss.close();
		System.out.println(">>> 程序执行结束 <<<");
	}
	
}











