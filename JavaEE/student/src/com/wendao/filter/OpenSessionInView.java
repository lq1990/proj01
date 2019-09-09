package com.wendao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.wendao.util.MyBatisUtil;

@WebFilter("/*")
public class OpenSessionInView implements Filter {
	Logger logger = Logger.getLogger(OpenSessionInView.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// set encoding
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// session
		SqlSession ss = MyBatisUtil.getSession();
		try {
			chain.doFilter(request, response);
			ss.commit();
			
		} catch(Exception e) {
			ss.rollback();
			e.printStackTrace(); // 测试时不注释，当上线后 此行注释，使用log4j
//			logger.error("");
		} finally {
			MyBatisUtil.closeSession();
		}
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}













