package com.wendao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.jdbc.SqlBuilder;

import com.wendao.entity.User;

public interface UserMapper {
	
	/**
	 * Provider系列注解：
	 * 	method属性：当前方法执行的时候，用于构建sql的方法是什么
	 * 	type属性：当前方法执行的时候，用于构建sql的类型是什么
	 * 
	 * @param user
	 * @return
	 */
	@InsertProvider(method="createInsertSQL", type = UserMapperProvider.class)
	public int insertUser(User user);
	
	
	/**
	 * 一次插入多个记录时，使用map。
	 * key：users
	 * value: List<User>
	 * 
	 * 
	 * 
	 * @param params
	 * @return
	 */
	@InsertProvider(method="createBatchInsert", type=UserMapperProvider.class)
	public int batchInserUser(Map<String, Object> params);
	
	
	/**
	 *  内部类.
	 *  
	 *  内部类中的方法中使用SQL构建类。也可以直接用StringBuilder替代。
	 *  反正都是返回的 String
	 * @author china
	 *
	 */
	static class UserMapperProvider {
		
		
		/**
		 *  insert into tb  (name,age) values (x,x),(x,x); 可插入多条记录
		 * @param params
		 * @return
		 */
		public String createBatchInsert(Map<String, Object> params) {
			StringBuilder builder = new StringBuilder();
			builder.append("insert into t_user (name,age) values ");
			
			List<User> users = (List<User>) params.get("users");
			for(int i=0; i<users.size(); i++) {
				if(i != 0) {
					builder.append(",");
				}
				
				builder.append("(#{users["+i+"].name}, #{users["+i+"].age})");
				
			}
			
			return builder.toString();
		}
		
		/**
		 * 	
		 * @param user 就是insertUser方法的参数。可以将参数中的数据进行计算，直接关联到sql语句中。
		 * 	insert into t_user (name) values (user.getName());
		 * @return
		 */
		public String createInsertSQL(User user) {
			System.out.println("UserMapper.UserMapperProvider.createInsertSQL(), user: "+user);
			
			// 创建sql构建工具. mybatis提供的一个专门用来构建SQL的类型。老版本是SqlBuilder
			SQL sql = new SQL();
			
			sql.INSERT_INTO("t_user");
			
			sql.VALUES("id", "#{id}"); // #{id}, user.id 属性值会被传过来
			sql.VALUES("name", "#{name}");
			sql.VALUES("age", "#{age}");
			
			
			System.out.println("UserMapper.UserMapperProvider.createInsertSQL(), sql: "+sql.toString());
			
			
			return sql.toString();
		}
		
		
		
		public String createUpdateSQL(User user) {
			System.out.println("UserMapper.UserMapperProvider.createUpdateSQL(), user:"+user);
			
			SQL sql = new SQL();
			
			sql.UPDATE("t_user");
			sql.SET("name=#{name}");
			sql.SET("age=#{age}");
			sql.WHERE("id=#{id}");
			
			System.out.println("UserMapper.UserMapperProvider.createUpdateSQL(): "+sql.toString());
			
			return sql.toString();
			
		}
		
		public String createDeleteSQL(Long id) {
			System.out.println("UserMapper.UserMapperProvider.createDeleteSQL(), id:"+id);
			
			SQL sql = new SQL();
			sql.DELETE_FROM("t_user");
			sql.WHERE("id=#{id}");
			
			
			System.out.println("UserMapper.UserMapperProvider.createDeleteSQL(), "+sql.toString());
			
			return sql.toString();
			
		}
		
		public String createSelectSQL(int page, int rows) {
			SQL sql = new SQL();
			sql.SELECT_DISTINCT("id, name, age");
			sql.FROM("t_user");
			sql.ORDER_BY("id");
			
			String rtn = sql.toString();
			
			rtn += " limit " + ((page-1)*rows)+", "+rows;
			System.out.println(rtn);
			
			return rtn;
		}
		
		
	}
	
}




