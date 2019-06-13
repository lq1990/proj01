package com.wendao.testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ResultSet
 * 
 * @author china
 *
 */
public class JDBC04 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
	 	Connection conn = DriverManager.getConnection(
	 			"jdbc:mysql://localhost:3306/testjdbc", 
	 			"root", 
	 			"123456");
	 	
	 	String sql = "select id,username,pwd from t_user where id>?";
	 	PreparedStatement ps = conn.prepareStatement(sql);
	 	ps.setObject(1, 10);
	 	
	 	ResultSet rs = ps.executeQuery(); // rs 为迭代器
	 	
	 	while(rs.next()) {
	 		System.out.println(rs.getObject(1)); // get 1.col 
	 		System.out.println(rs.getObject(2)); // get 2.col 
	 	}
	 	
	 	rs.close();
	 	ps.close();
	 	conn.close();
	}
}
