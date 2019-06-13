package com.wendao.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


/**
 * 
 * @author china
 *
 */
public class JDBC03PreparedStatement {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class clz = Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "root", "123456");
		
		
		String sql = "insert into t_user (username,pwd,regTime) values (?,?,?)"; // ? 占位符
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "高琪"); // 第一个是参数索引，从1开始
		ps.setString(2, "12121");
//		ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
		ps.setDate(3, (java.sql.Date) new Date());
		
//		ps.setObject(1, "溜溜");
//		ps.setObject(2, "898989");
		
//		ps.execute();
		System.out.println(ps.executeUpdate());
		
		
		
		System.out.println("over");
		conn.close();
	}
}