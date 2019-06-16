package com.wendao.sorm.core;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wendao.sorm.bean.ColumnInfo;
import com.wendao.sorm.bean.TableInfo;
import com.wendao.sorm.utils.JDBCUtils;
import com.wendao.sorm.utils.ReflectUtils;

/**
 * 	负责查询（对外提供服务的核心类）
 * 		DML(CRUD)
 * 
 * 	将Query由interface变为抽象类。
 * 	模板方法。
 * 
 * @author china
 *
 */
public abstract class Query implements Cloneable {
	
	/**
	 * 	采用模板方法模式，将JDBC操作封装成模板，便于重用。
	 * @param sql sql语句
	 * @param params sql的参数
	 * @param clz 记录要封装到的javabean类
	 * @param cb 回调函数，内部是匿名函数
	 * @return 查询结果
	 */
	public Object executeQueryTemplate(String sql, Object[] params, Class clz, CallBack cb) {
		Connection conn = DBManager.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			// 给sql设参
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			return cb.doExecute(conn, ps, rs);
			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBManager.close(rs, ps, conn);
		}
		
	}

	/**
	 * 	直接执行一个DML语句
	 * @param sql sql语句
	 * @param params 参数
	 * @return 执行sql语句后影响记录的行数
	 */
	public int executeDML(String sql, Object[] params){
		// DML: CRUD
		Connection conn = DBManager.getConn();
		int count = 0;
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			// 给sql设参
			JDBCUtils.handleParams(ps, params);
			
			System.out.println(ps);
			
			count = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(ps, conn);
		}
		
		return count;
	}
	
	/**
	 * 	将一个对象存储到db中。
	 * 	把不为null的属性往db中存储。
	 * 	若数字为null，则为0。
	 * 
	 * @param obj 要存储的对象
	 */
	public void insert(Object obj) {
		// obj --> table.
		// insert into tname (f1,f2,f3) values (?,?,?);
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>(); // 存储sql的参数对象
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		StringBuilder sql = new StringBuilder("insert into "+
				tableInfo.getTname()+ 
				" (");
		
		Field[] fs = c.getDeclaredFields();
		int countNotNullField = 0; // 记录不是null的
		for (Field f : fs) {
			String fieldName = f.getName();
			Object fieldValue = ReflectUtils.invokeGet(fieldName, obj);
			if (null != fieldValue) {
				countNotNullField++;
				sql.append(fieldName+",");
				params.add(fieldValue);
			}
		}
		
		sql.setCharAt(sql.length()-1, ')');
		sql.append(" values (");
		for(int i=0; i<countNotNullField; i++) {
			sql.append("?,");
		}
		sql.setCharAt(sql.length()-1, ')'); // 至此，sql语句合成完毕
		
		executeDML(sql.toString(), params.toArray());
		
	}
	
	/**
	 * <pre>
	 * 	删除clz类对应的表中的记录（指定主键值id的记录）
	 * 	注：按照主键来删除。
	 * </pre>
	 * @param clz 跟表对应的类的Class对象
	 * @param id 主键的值
	 * @return
	 */
	public void delete(Class clz, Object id) {
		// Emp.class,2 --> delete from emp where id=2;
		
		// 问题：通过Class对象找TableInfo。但table名多变，不容易实现。所以借助 TableContext->poClassTableMap 实现映射
		TableInfo tableInfo = TableContext.poClassTableMap.get(clz);
		// 主键
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
		
		String sql = "delete from "+tableInfo.getTname()+" where "+onlyPriKey.getName() + "=? ";
		
		executeDML(sql, new Object[] {id}); 
		// 第二个参：Object数组，为静态初始化方式
		
	}
	
	/**
	 * 	删除对象在db中对应的记录（对象所在的类对应到表，对象的主键的值对应到记录）
	 * @param obj
	 * @return
	 */
	public int delete(Object obj) {
		Class<?> c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey(); // 获得主键
		
		// 通过反射机制，调用属性对应的get set方法
		Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), obj);
		delete(c, priKeyValue);
		
		return 0;
	}
	
	
	/**
	 * 	更新对象对应的记录，并且只更新指定的字段的值
	 * @param obj 所要更新的对象
	 * @param fieldNames 更新的属性列表
	 * @return
	 */
	public int update(Object obj, String[] fieldNames) {
		// obj{"uname","pwd"} --> update tname set uname=?,pwd=? where id=?
		Class c = obj.getClass();
		List<Object> params = new ArrayList<Object>();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo priKey = tableInfo.getOnlyPriKey();
		StringBuilder sql = new StringBuilder("update "+tableInfo.getTname()+" set ");
		
		for(String fname:fieldNames) {
			Object fvalue = ReflectUtils.invokeGet(fname, obj);
			params.add(fvalue);
			sql.append(fname+"=?,");
		}
		
		sql.setCharAt(sql.length()-1, ' ');
		sql.append(" where ");
		sql.append(priKey.getName()+"=? "); // sql finished
		
		params.add(ReflectUtils.invokeGet(priKey.getName(), obj)); // priKey
		
		return executeDML(sql.toString(), params.toArray());
		
	}
	
	/**
	 * 	多行多列。
	 * 	查询返回多行记录，并将每行记录封装到clz对象
	 * @param sql 查询语句
	 * @param clz 封装数据的javabean对象
	 * @param params sql语句的参数
	 * @return 查询到结果
	 */
	public List queryRows(final String sql, final Class clz, final Object[] params) {
		List list = null; // 用final修饰，只能初始化一次
		
		list = (List) executeQueryTemplate(sql, params, clz, new CallBack() {
			// 使用匿名内部类。内部类返回的结果就是此处外部fn的返回值

			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				final List<Object> list = new ArrayList();
				
				try {
					ResultSetMetaData metaData = rs.getMetaData();
					// 多行
					while(rs.next()) {
						Object rowObj = clz.newInstance(); // 调用无参构造器
						
						// 多列 select username,pwd,age from user where id>2 and id<10;
						for(int i=0; i<metaData.getColumnCount(); i++) {
							String columnName = metaData.getColumnLabel(i+1); // username
							Object columnValue = rs.getObject(i+1);
							
							// 调用rowObj对象的setUsername(String uname) 方法，将columnValue 设置进去
							ReflectUtils.invokeSet(rowObj, columnName, columnValue);
						}
						
						list.add(rowObj);
					}
					
				} catch(Exception e ) {
					e.printStackTrace();
				}
				
				return list;
			}
			
		});
		
		return list;
	}
	
	/**
	 * 	一行多列。
	 * 	查询返回 1行记录，并将每行记录封装到clz对象
	 * @param sql 查询语句
	 * @param clz 封装数据的javabean对象
	 * @param params sql语句的参数
	 * @return 查询到结果
	 */
	public Object queryUniqueRow(String sql, Class clz, Object[] params) {
		List list = queryRows(sql, clz, params);
		
		return (null==list && list.size()>0)?null:list.get(0);
	}

	
	/**
	 * 	一行1列。
	 * @param sql 查询语句
	 * @param params sql语句的参数
	 * @return 查询到结果
	 */
	public Object queryValue(String sql, Object[] params) {
		
		return executeQueryTemplate(sql, params, null, new CallBack() {
			
			@Override
			public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
				Object value = null;
				try {
					while(rs.next()) {
						// select count(*) from emp;
						value = rs.getObject(1);
					}
				} catch(Exception e) {
					e.printStackTrace();				}
				
				return value;
			}
		});
		
	}
	
	/**
	 * 	一行1列。
	 * 	返回一个数字。
	 * @param sql 查询语句
	 * @param params sql语句的参数
	 * @return 查询到结果
	 */
	public Number queryNumber(String sql, Object[] params) {
		return (Number)queryValue(sql, params);
	}
	
	/**
	 * 	分页查询
	 * @param pageNum 第几页数据
	 * @param size 每页显示多少
	 * @return
	 */
	public abstract Object queryPaginate(int pageNum, int size);
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone(); // 浅克隆 shallow copy
	}
	
}































































