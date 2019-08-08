package com.wendao.DML;

import java.sql.Connection; // 注意：导入的 Connection和DriverManager 都是java.sql
import java.sql.DriverManager;

/**
 * jdbc:
 * 	1. 导入jdbc驱动包
 * 	2.
 * @author china
 *00
 */
public class TestInsert1 {
	public static void main(String[] args) throws Exception {
		System.out.println("test insert...");
		
		// 1. 加载驱动类
		Class.forName("com.mysql.jdbc.Driver"); // oracle.jdbc.driver.OracleDriver
		
		// 2 获取数据库连接对象（连接指定的数据库)
	    String url = "jdbc:mysql://localhost:3306/db01";
		String user = "root";
		String password = "123456";
		Connection conn =  DriverManager.getConnection(url, user, password);
		
		// 3 获取sql命令对象
		
		
		
		
	}
}
