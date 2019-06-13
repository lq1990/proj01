package com.wendao.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 使用 Statement，SQL注入问题
 * @author china
 *
 */
public class JDBC02Statement {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 加载驱动类
		Class.forName("com.mysql.jdbc.Driver");
		// 建立连接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/testjdbc", 
				"root", 
				"123456");

		Statement stmt = conn.createStatement();
//		String name = "赵七";
//		String sql = "insert into t_user (username,pwd,regTime) values ('"+name+"',666,now())";
//		stmt.execute(sql);
		
		// 测试 sql注入
		String id = "5 or 1=1"; // 此时，整个库数据被delete。即：user可任意修改
		String sql = "delete from t_user where id="+id;
		stmt.execute(sql);
		
		
		
		System.out.println("over");
		stmt.close();
		conn.close();
	}
}
