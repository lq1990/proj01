package com.wendao.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author china
 *
 */
public class JDBC05Batch {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/testjdbc",
					"root",
					"123456");
			
			conn.setAutoCommit(false); // jdbc事务 默认是 自动提交，batch操作的话，要手动set false

			long start = System.currentTimeMillis();
			
			stmt = conn.createStatement();
			for(int i=0; i<20000; i++) {
				stmt.addBatch("insert into t_user (username,pwd,regTime) values ('gao"+i+"',666666,now())");
			}
			stmt.executeBatch();
			conn.commit();
			
			System.out.println("20k records, time needed: "+(System.currentTimeMillis()-start)+"ms");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stmt) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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














