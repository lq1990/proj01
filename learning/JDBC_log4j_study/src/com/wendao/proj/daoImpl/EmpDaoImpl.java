package com.wendao.proj.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.wendao.proj.dao.EmpDao;
import com.wendao.proj.pojo.Emp;

public class EmpDaoImpl implements EmpDao {
	// 查询所有员工信息
	public ArrayList<Emp> selAllEmpInfo() {
		// 声明JDBC对象
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 声明集合对象
		ArrayList<Emp> list = null;
		
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		// 获取连接对象
		String url = "jdbc:mysql://localhost:3306/sorm";
		String user = "root";
		String pwd = "123456";
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			
			// 创建sql命令
			String sql = "select * from emp";
			ps = conn.prepareStatement(sql);
			
			// execute sql
			rs = ps.executeQuery();
			list = new ArrayList<Emp>(); // 把list初始化写在rs后面，当rs报错时，list为null
			
			// 遍历查询结果
			while(rs.next()) {
				Emp p = new Emp();
				p.setEmpno(rs.getInt("empno"));
				p.setEname(rs.getString("ename"));
				p.setSal(rs.getDouble("sal"));
				p.setDeptId(rs.getInt("deptId"));
				p.setAge(rs.getInt("age"));
				p.setBonus(rs.getDouble("bonus"));
				p.setBirthday(rs.getDate("birthday"));
				list.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			close(conn, ps, rs);
		}
		
		// 返回结果
		return list;
	}
	
	// 根据编号查询员工信息
	public Emp selEmpInfoByEmpno(int empno) {
		// 声明jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// Emp obj
		Emp p = null;
		
		try {
			// load driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// get conn obj
			String url = "jdbc:mysql://localhost:3306/sorm";
			String user = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url, user, password);
			
			// sql
			String sql = "select * from emp where empno=?";
			ps = conn.prepareStatement(sql);
			
			// 给占位符赋值
			ps.setInt(1, empno); // 1-based indexing
			
			// 执行sql
			rs = ps.executeQuery();
			
			// 遍历结果
			while(rs.next()) {
				p = new Emp();
				p.setEmpno(rs.getInt("empno"));
				p.setEname(rs.getString("ename"));
				p.setSal(rs.getDouble("sal"));
				p.setDeptId(rs.getInt("deptId"));
				p.setAge(rs.getInt("age"));
				p.setBonus(rs.getDouble("bonus"));
				p.setBirthday(rs.getDate("birthday"));
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
		} finally {
			// 关闭资源
			close(conn, ps, rs);
		}
		
		// 返回结果
		return p;
	}
	
	/**
	 *	添加员工信息
	 * @param empno
	 * @param ename
	 * @param sal
	 * @param deptId
	 * @param age
	 * @param bonus
	 * @param birthday
	 * @return the row count for SQL Data Manipulation Language (DML) statements
	 */
	public int insEmpInfo(int empno, String ename, 
			double sal, int deptId, int age, double bonus, Date birthday) {
		// jdbc obj
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int res = 0;
		try {
			// get conn obj
			String url = "jdbc:mysql://localhost:3306/sorm";
			String user = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url, user, password);
			
			conn.setAutoCommit(false); // 设置为 不自动commit
			// sql
			String sql = "insert into emp values (?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, empno);
			ps.setString(2, ename);
			ps.setDouble(3, sal);
			ps.setInt(4, deptId);
			ps.setInt(5, age);
			ps.setDouble(6, bonus);
			// java.util.Date => java.sql.Date
			java.sql.Date d = new java.sql.Date(birthday.getTime());
			ps.setDate(7, d);
			
			// 
			res = ps.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// free
			close(conn, ps, rs);
		}
		
		// return
		return res;
		
	}
	
	
	// 修改员工姓名
	public int upEmp(String newName, int empno) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int res = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/sorm";
			String user = "root";
			String pwd = "123456";
			conn = DriverManager.getConnection(url, user, pwd);
			conn.setAutoCommit(false);
			
			String sql = "update emp set ename=? where empno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setInt(2, empno);
			
			res = ps.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
		} finally {
			close(conn, ps, rs);
		}
		
		return res;
	}
	
	// 删除员工信息
	public int delEmp(int empno) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int res = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/sorm";
			String user = "root";
			String pwd = "123456";
			conn = DriverManager.getConnection(url, user, pwd);
			conn.setAutoCommit(false);
			
			String sql = "delete from emp where empno=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			
			res = ps.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(conn, ps, rs);
		}
		
		return res;
	}

	
	
	private void close(AutoCloseable... autoCloseables) {
		for (AutoCloseable autoCloseable : autoCloseables) {
			if (autoCloseable != null) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
