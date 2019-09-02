package com.wendao.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.wendao.pojo.User;
import com.wendao.service.UserService;
import com.wendao.service.impl.UserServiceImpl;

/**
 * Servlet相当于 Controller
 * 
 * Servlet重定向路径总结：
 * 	相对路径：从当前请求的路径查找资源的路径
 * 		相对路径如果servelt的别名 包含目录，会造成重定向资源查找失败。
 * 	绝对路径：推荐使用
 * 		/虚拟项目名/资源路径
 * 		第一个/ 表示服务器根目录
 * 
 * 	Servlet请求转发中：
 * 		/ 表示根目录
 * 		req.getRequestDispatcher("/资源路径").forward(req, resp);
 * 
 * 
 * @author china
 *
 */
public class UserServlet extends HttpServlet {
	Logger logger = Logger.getLogger(UserServlet.class);
	UserService us = new UserServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 获取操作符,url中query参数
		String oper = req.getParameter("oper");
		
		if("login".equals(oper)) {
			// 调用登录处理方法
			checkUserLogin(req, resp);
			
		} else if ("reg".equals(oper)) {
			// 调用注册功能
			userReg(req, resp);
			
		} else if("out".equals(oper)) {
			// 调用退出，退出时销毁session。联想到当session失效时 用户需要重新填信息，一个道理
			userOut(req, resp);
			
		} else if ("pwd".equals(oper)) {
			// 调用密码修改功能
			userChangePwd(req, resp);
			
		}
		else if ("showAll".equals(oper)) {
			// 显示所有用户功能
			userShow(req, resp);
			
		}
		else {
			logger.debug("没有找到对应的操作符："+oper); // 关于logger使用；方法体内用debug，调用方法处使用info
		}
		
	}

	/**
	 * 	用户点击注册时，处理
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 获取请求信息
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String sex = req.getParameter("sex");
		String age_str = req.getParameter("age");
		int age = !age_str.equals("") ? Integer.parseInt(age_str) : 0;
		String birth = birthTrans(req.getParameter("birth")) ;
		
		System.out.println(uname+":"+pwd+":"+sex+":"+age+":"+birth);
		User u = new User(0, uname, pwd, sex, age, birth);
		
		// 处理请求信息
			// 调用业务层处理
			int index = us.userRegService(u);
			System.out.println(index);
			
		// 响应处理结果
			if(index > 0) {
				req.getSession().setAttribute("reg", 2);
				
				resp.sendRedirect("/mg/login.jsp");
			}
		
	}
	
	private String birthTrans(String birth) {
		if("".equals(birth)) {
			return "";
		}
		
		String[] bs = null;
		if(birth != "") {
			bs = birth.split("/");
		}
		
		String res = "";
		res += bs[2] + "-" + bs[0] + "-" + bs[1];
		
		return res;
	}
	

	/**
	 * 	显示所有的用户信息。
	 * 		用到：Servlet -- Service -- Dao -- db
	 * 			Servlet -- view
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void userShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// req
			// 调用service
			List<User> lu = us.userShowService();
		
			if(lu != null) {
				// 使用请求转发 优于使用session，避免session垃圾
				req.setAttribute("lu", lu);
				req.getRequestDispatcher("/user/allUsers.jsp").forward(req, resp);
				return;
			}
			
	}

	// 用户修改密码
	private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 获取数据
			// 获取新密码数据
			String newPwd = req.getParameter("newPwd");// get query param
			
			// update set 时，sql语句中需要传 uid。通过session获取
			User u = (User) req.getSession().getAttribute("user");
			int uid = u.getUid();
		
		// 处理请求
			// 调用service处理
			int index = us.userChangePwdService(newPwd, uid);
			// 密码修改成功后，显示消息提示且 重新登录
			if (index > 0) { // 此时密码修改结束，db更新
				// 获取session对象
				HttpSession hs = req.getSession();
				hs.setAttribute("pwd", 1);
				
				// 重定向到 登录页面
				resp.sendRedirect("/mg/login.jsp");
				
			}
			
	}

	private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 获取session对象
		HttpSession hs = req.getSession();
		
		// 强制销毁
		hs.invalidate();
		
		// 重定向到登录页面
		resp.sendRedirect("login.jsp");
		
	}

	// 处理登录
	private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// get info of req
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		
		// process req
			// 获取service层对象
			
			// 校验
			User u = us.checkUserLoginService(uname, pwd);
			if(u != null) {
				// get session
				HttpSession hs = req.getSession();
				// 将用户数据存储到session中
				hs.setAttribute("user", u);
				
				// 重定向
				resp.sendRedirect("/mg/main/main.jsp"); // WebRoot/ 下面绝对路径
				//    main/main.jsp 或者写： /mg/main/main.jsp 也是绝对路径
				// 不要用相对路径，因为web.xml中若配置的servlet可能是目录 /a/b，若用相对路径则出错
				return;
			} else {
				// db中没有此用户
				
				// 添加标识符到request中
				req.setAttribute("flag", 0);
				
				// db中没有这个用户，返回登录页面。使用请求转发
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
				
				return;
			}
		
	}
	
}














