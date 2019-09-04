package com.wendao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取context.xml 
		Context ctx;
		try {
			// ----------- jndi代码 -----------
			ctx = new InitialContext();
				// 获取数据库连接池对象
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/test"); // 固定字符串 java:comp/env/, test是context.xml中name
			Connection conn = ds.getConnection();
			
			// ----------------------------
			
			PreparedStatement ps = conn.prepareStatement("select * from flower");
			ResultSet rs = ps.executeQuery();
			
			PrintWriter out = resp.getWriter();
			while(rs.next()) {
				out.print(rs.getObject(1)+":"+rs.getObject(2)+":"
						+rs.getObject(3)+":"+rs.getObject(4)+"<br/>");
				
			}
			
			out.flush();
			out.close();
			
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
