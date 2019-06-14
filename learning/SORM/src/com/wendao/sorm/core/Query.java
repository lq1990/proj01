package com.wendao.sorm.core;

import java.util.List;

/**
 * 	负责查询（对外提供服务的核心类）
 * 		DML(CRUD)
 * 
 * @author china
 *
 */
public interface Query {

	/**
	 * 	直接执行一个DML语句
	 * @param sql sql语句
	 * @param params 参数
	 * @return 执行sql语句后影响记录的行数
	 */
	public int executeDML(String sql, Object[] params);
	
	/**
	 * 	将一个对象存储到db中。
	 * 	把不为null的属性往db中存储。
	 * 	若数字为null，则为0。
	 * 
	 * @param obj 要存储的对象
	 */
	public void insert(Object obj);
	
	/**
	 * <pre>
	 * 	删除clz类对应的表中的记录（指定主键值id的记录）
	 * 	注：按照主键来删除。
	 * </pre>
	 * @param clz 跟表对应的类的Class对象
	 * @param id 主键的值
	 * @return
	 */
	public void delete(Class clz, Object id); // sql: delete from User where id=1;
	
	/**
	 * 	删除对象在db中对应的记录（对象所在的类对应到表，对象的主键的值对应到记录）
	 * @param obj
	 * @return
	 */
	public int delete(Object obj);
	
	
	/**
	 * 	更新对象对应的记录，并且只更新指定的字段的值
	 * @param obj 所要更新的对象
	 * @param fieldNames 更新的属性列表
	 * @return
	 */
	public int update(Object obj, String[] fieldNames); // update user set uname=?,pwd=?
	
	/**
	 * 	多行多列。
	 * 	查询返回多行记录，并将每行记录封装到clz对象
	 * @param sql 查询语句
	 * @param clz 封装数据的javabean对象
	 * @param params sql语句的参数
	 * @return 查询到结果
	 */
	public List queryRows(String sql, Class clz, Object[] params);
	
	/**
	 * 	一行多列。
	 * 	查询返回 1行记录，并将每行记录封装到clz对象
	 * @param sql 查询语句
	 * @param clz 封装数据的javabean对象
	 * @param params sql语句的参数
	 * @return 查询到结果
	 */
	public Object queryUniqueRow(String sql, Class clz, Object[] params);
	
	/**
	 * 	一行1列。
	 * @param sql 查询语句
	 * @param params sql语句的参数
	 * @return 查询到结果
	 */
	public Object queryValue(String sql, Object[] params);
	
	/**
	 * 	一行1列。
	 * 	返回一个数字。
	 * @param sql 查询语句
	 * @param params sql语句的参数
	 * @return 查询到结果
	 */
	public Number queryNumber(String sql, Object[] params);
	
	
	
}




































