package com.wendao.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wendao.dao.UserDao;
import com.wendao.pojo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User checkUserLoginDao(String uname, String pwd) {
		// 声明jdbc对象, conn, ps, rs
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 声明变量
		User u = null;
		
		try {
			// 加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			// get conn
			String url = "jdbc:mysql://localhost:3306/class";
			conn = DriverManager.getConnection(url, "root", "123456");
			
			// sql
			String sql = "select * from t_user where uname=? and pwd=?";
			
			// get ps
			ps = conn.prepareStatement(sql);
			
			// 占位符填充
			ps.setString(1, uname);
			ps.setString(2, pwd);
			
			// rs
			rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// free
			if (conn != null) {
				try {
					conn.close();
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		// return
		return u;
	}

	
	@Override
	public int userChangePwdService(String newPwd, int uid) {
		// jdbc objs: conn,ps,rs
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int index = 0;
		
		try {
			// load Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// get conn
			String url = "jdbc:mysql://localhost:3306/class";
			conn = DriverManager.getConnection(url, "root", "123456");
			
			// sql
			String sql = "update t_user set pwd=? where uid=?";
			
			// set objs in ps
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPwd);
			ps.setInt(2, uid);
			
			// get rs from ps, get result
			index = ps.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// free
			if (conn != null) {
				try {
					conn.close();
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		// return
		return index;
	}

	@Override
	public List<User> userShowDao() {
		// 声明jdbc对象, conn, ps, rs
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 声明变量
		List<User> lu = null;
		
		try {
			// 加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			// get conn
			String url = "jdbc:mysql://localhost:3306/class";
			conn = DriverManager.getConnection(url, "root", "123456");
			
			// sql
			String sql = "select * from t_user";
			
			// get ps
			ps = conn.prepareStatement(sql);
			
			// 占位符填充
			
			// rs
			rs = ps.executeQuery();
			lu = new ArrayList<User>();
			while(rs.next()) {
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirth(rs.getString("birth"));
				
				lu.add(u);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// free
			if (conn != null) {
				try {
					conn.close();
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		// return
		return lu;
	}


	/**
	 * 用户注册后，
	 * 将u信息 插入到db中
	 */
	@Override
	public int userRegDao(User u) {
		// 声明jdbc对象, conn, ps, rs
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 声明变量
		int index = 0;
		
		try {
			// 加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			// get conn
			String url = "jdbc:mysql://localhost:3306/class";
			conn = DriverManager.getConnection(url, "root", "123456");
			
			// sql
			String sql = "insert into t_user values (default,?,?,?,?,?)";
			
			// get ps
			ps = conn.prepareStatement(sql);
			
			// 占位符填充
			ps.setString(1, u.getUname());
			ps.setString(2, u.getPwd());
			ps.setString(3, u.getSex());
			ps.setInt(4, u.getAge());
			ps.setString(5, u.getBirth());

			// rs
			index = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// free
			if (conn != null) {
				try {
					conn.close();
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		// return
		return index;
	}
	
}
