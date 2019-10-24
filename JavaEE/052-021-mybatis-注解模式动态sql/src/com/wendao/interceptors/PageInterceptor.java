package com.wendao.interceptors;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * mybatis-Interceptor，拦截代码中的db访问，修改
 * @author china
 * @Intercepts 注解。代表当前的类型是一个MyBatis的拦截器。必要的注解。
 * 	其中必要属性是一个数组类型的属性。数组的类型是@Signature.
 * @Signature注解。要拦截的内容。
 * 		method: query 对应statement的executeQuery方法(查询操作); update对应executeUpdate（增删改）
 *		type: 拦截的驱动的类型。Executor是mybatis底层访问数据库时封装的操作接口。类似jdbc的statement
 *		args: 通知mybatis框架，当前的拦截器中拦截方法intercept参数invocation需要提供多少个参数
 *				1. MappedStatement是访问db相关， 2. Mapper接口中方法的传递的参数，
 *				3. RowBounds伪分页用的，行绑定器， 4. ResultHandler处理结果
 */

@Intercepts(
		{ 
				@Signature(args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }, 
						method = "query", 
						type = Executor.class) 
				
		}
)
public class PageInterceptor implements Interceptor{

	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		// 获取参数数据。是注解中配置的信息
		Object[] args = invocation.getArgs();
		System.out.println("args: "+Arrays.toString(args));
		
		// 获取映射处理器
		MappedStatement statement = (MappedStatement) args[0];
		// 拦截的方法的参数表。UserMapper中方法参数
		Map<String, Object> parameter = (Map<String, Object>) args[1];
		// 结果处理器。就是查询结果处理器。类似封装好的一个ResultSet
		ResultHandler handler = (ResultHandler)args[3];
		
		// 获取拦截的方法
		Method method = invocation.getMethod();
		System.out.println("method: "+method);
		
		// 获取执行器。类似JDBC中的Statement
		Executor target = (Executor) invocation.getTarget();
		System.out.println("target: "+target);
		
		// 通过MappedStatement获取的sql语句。
		BoundSql bSql = statement.getBoundSql(parameter);
		System.out.println(bSql.getSql());
		
		String pageSql = this.toPageSql(bSql.getSql(), parameter);
		System.out.println(pageSql);
		
		// 定义一个新的sql。用于替换拦截的方法要执行的sql
		BoundSql pageBoundSql = new BoundSql(statement.getConfiguration(), pageSql, bSql.getParameterMappings(), parameter);
		
		// 缓存。当执行查询后，会将查询结果缓存到一级缓存中。
		CacheKey cacheKey = target.createCacheKey(statement, parameter, RowBounds.DEFAULT, pageBoundSql);
		
		List<Object> tmp = target.query(statement, parameter, RowBounds.DEFAULT, handler);
		
		
		return tmp;
	}

	private String toPageSql(String sql, Object parameter) {
		Map<String, Object> paramMap = this.transParameter(parameter);
		
		StringBuilder builder = new StringBuilder();
		builder.append(sql);
		builder.append("limit ")
			.append(paramMap.get("start"))
			.append(", ")
			.append(paramMap.get("limit"));
		
		return builder.toString();
	}
	
	
	private Map<String , Object> transParameter(Object parameter) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(parameter instanceof Map) {
			Map<String, Object> sourceParam = (Map<String, Object>) parameter;
			int page = Integer.parseInt(sourceParam.get("page").toString());
			int rows = Integer.parseInt(sourceParam.get("rows").toString());
			paramMap.put("start", (page-1) * rows);
			paramMap.put("limit", rows);
				
			return paramMap;
		}
		else {
			return null;
		}
	}
	
	@Override
	public Object plugin(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperties(Properties arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
