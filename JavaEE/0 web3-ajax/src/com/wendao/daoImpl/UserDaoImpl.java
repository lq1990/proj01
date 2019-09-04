package com.wendao.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wendao.dao.UserDao;
import com.wendao.pojo.User;

/**
 * 	操作db
 * @author china
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public User getUserInfo(String uname) {
		// jdbc objs, conn ps rs
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User u = null;
		
		try {
			// load Driver
			Class.forName("com.mysql.jdbc.Driver");
		
			// get conn
			String url = "jdbc:mysql://localhost:3306/class";
			conn = DriverManager.getConnection(url, "root", "123456");
			
			// sql
			String sql = "select * from t_heros where uname=?";
			
			// ps, set objs
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			
			// rs
			rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPrice(rs.getDouble("price"));
				u.setLoc(rs.getString("loc"));
				u.setDes(rs.getString("des"));
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// free
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
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

}
