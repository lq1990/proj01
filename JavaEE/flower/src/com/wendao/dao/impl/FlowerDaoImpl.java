package com.wendao.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.wendao.dao.FlowerDao;
import com.wendao.pojo.Flower;

public class FlowerDaoImpl implements FlowerDao {

	@Override
	public List<Flower> selAll() {
		// jdbc conn, ps, rs
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// entity
		List<Flower> lf = null;
		
		try {
			// load Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// get conn
			String url = "jdbc:mysql://localhost:3306/ssm";
			conn = DriverManager.getConnection(url, "root", "123456");
			
			// sql
			String sql = "select * from flower";
			
			// ps, set
			ps = conn.prepareStatement(sql);
			
			// rs
			rs = ps.executeQuery(); // rs指向一行数据，rs.next()指向下一个
			
			lf = new ArrayList<Flower>();
			while(rs.next()) {
				Flower f = new Flower();
				f.setId(rs.getInt("id"));
				f.setName(rs.getString("name"));
				f.setPrice(rs.getDouble("price"));
				f.setProduction(rs.getString("production"));
				
				lf.add(f);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// free
			close(conn, ps, rs);
		}
		
		
		// return
		return lf;
	}

	@Override
	public int insFlower(Flower flower) {
		// jdbc conn, ps, rs
		Connection conn = null;
		PreparedStatement ps = null;
		
		int num = 0;
		
		try {
			// load Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// get conn
			String url = "jdbc:mysql://localhost:3306/ssm";
			conn = DriverManager.getConnection(url, "root", "123456");
			
			// sql
			String sql = "insert into flower values (default,?,?,?)";
			
			// ps, set
			ps = conn.prepareStatement(sql);
			ps.setObject(1, flower.getName());
			ps.setObject(2, flower.getPrice());
			ps.setObject(3, flower.getProduction());
			
			// rs
			num = ps.executeUpdate(); // rs指向一行数据，rs.next()指向下一个
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps);
		}
		
		// return
		return num;
	}

	private void close(AutoCloseable... autoCloseables) {
		for (AutoCloseable ac : autoCloseables) {
			if (ac != null) {
				try {
					ac.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
