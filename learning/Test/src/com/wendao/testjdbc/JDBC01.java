package com.wendao.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * connect
 * @author china
 *
 */
public class JDBC01 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// load class
			Class<?> clz = Class.forName("com.mysql.jdbc.Driver");
			
			// connect, conn 是一个实现类 com.mysql.jdbc.JDBC4Connection@533ddba
			// 建立连接很耗时
			conn = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", 
							"root", "123456");
			System.out.println(conn);
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
}








