package com.wendao.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 三个方法： (pre)--> controller -(post)-> jsp -->(after)
 * 
 * @author china
 *
 */
public class DemoInterceptor2 implements HandlerInterceptor {
	/**
	 * 在控制器之前执行， 若返回false，阻止进入控制器。
	 * 
	 * 	应用场景：
	 * 	用户没有登录的话，页面跳转到登陆页面， return false
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2) throws Exception {

		System.out.println("DemoInterceptor2.preHandle()");
		
		System.out.println("arg2是被拦截的方法: "+arg2);
		
		return true;
	}
	

	/**
	 * 在控制器执行完成，进入到jsp之前执行.
	 * 
	 * 	功能：
	 * 	日志记录：比如谁注册了登陆了，页面访问多少次
	 * 	敏感词语处理
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, 
			HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
		System.out.println("DemoInterceptor2.postHandle(), "+", 跳转到："+arg3.getViewName()+
				", model的值："+arg3.getModel().get("model"));
		
		// springmvc可以对model进行修改
//		arg3.getModel().put("model", "修改过的model值");
		
		// 把敏感词语替换
		String word = arg3.getModel().get("model").toString();
		String newWord = word.replace("垃圾", "**");
		arg3.getModel().put("model", newWord);
		
	}

	/**
	 * jsp执行完成后
	 * 
	 * 功能：
	 * 	异常收集：记录执行过程中出现的异常。若没有异常，则arg3=null
	 * 	
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, 
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("DemoInterceptor2.afterCompletion()");
		if(arg3 != null) {
			System.out.println("异常信息："+arg3.getMessage());
		}
		
	}
	
}











