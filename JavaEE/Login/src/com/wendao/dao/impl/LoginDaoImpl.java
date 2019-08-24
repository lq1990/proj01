package com.wendao.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wendao.dao.LoginDao;
import com.wendao.pojo.User;

public class LoginDaoImpl implements LoginDao {

	@Override
	public User checkLoginDao(String uname, String pwd) {
		// 导入mysql connector jar包
		// 声明jdbc对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 声明数据存储对象
		User u = null;
		
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			// 获取连接对象
			String url = "jdbc:mysql://localhost:3306/class";
			conn = DriverManager.getConnection(url, "root", "123456");
			// 创建sql命令
			String sql = "select * from t_user where uname=? and pwd=?";
			
			// 创建sql命令对象
			ps = conn.prepareStatement(sql);
			
			// 给占位符赋值
			ps.setString(1, uname);
			ps.setString(2, pwd);
			
			// 执行
			rs = ps.executeQuery();
			
			// 遍历执行结果
			while (rs.next()) {
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		// return
		return u;
	}
	
}
