package com.wendao.filter;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wendao.util.MyBatisUtil;

/**
 * 	filter过滤的是 servlet，相当于过滤的service.
 * 
 * 	OpenSessionInView的由来：
 * 		Spring整合Hibernate时使用的是OpenSessionInView。
 * 		即访问view层（理解为servlet+jsp）时，open一个session。
 * 		
 * 
 * @author china
 *
 */
@WebFilter("/*")
public class OpenSessionInView implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
//		InputStream is = Resources.getResourceAsStream("mybatis.xml");
//		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
//		SqlSession ss = fac.openSession();
		
		SqlSession ss = MyBatisUtil.getSession();
		// 通过此方法get的session，因为使用ThreadLocal，同一个线程的session一致。
		
		// 往下传
		try {
			chain.doFilter(request, response);
			ss.commit();
			
		} catch (Exception e) {
			ss.rollback(); // 在往下传给servlet（service...）时，若有异常，则回滚
			e.printStackTrace();
			
		} finally {
			
			// session的关闭也是 由OpenSessionInView负责
			MyBatisUtil.closeSession();
		}
		
//		ss.commit();
//		ss.close();
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}













