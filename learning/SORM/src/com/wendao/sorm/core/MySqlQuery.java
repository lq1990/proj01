package com.wendao.sorm.core;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wendao.po.Emp;
import com.wendao.sorm.bean.ColumnInfo;
import com.wendao.sorm.bean.TableInfo;
import com.wendao.sorm.utils.JDBCUtils;
import com.wendao.sorm.utils.ReflectUtils;
import com.wendao.sorm.utils.StringUtils;

public class MySqlQuery implements Query {
	
	public static void testDML() {
		Emp e = new Emp();
		e.setId(1);
		e.setEmpname("伏熊");
		e.setAge(19);
		e.setSalary(100001.0);
		e.setBirthday(new java.sql.Date(System.currentTimeMillis()));
//		new MySqlQuery().delete(e);
		
//		new MySqlQuery().insert(e);
		
//		new MySqlQuery().update(e, new String[] {"empname", "age", "salary"});
	}
	
	public static void main(String[] args) {
		List<Emp> list = new MySqlQuery().queryRows("select id,empname,age from emp where age>? and salary>?", 
				Emp.class, 
				new Object[] {
						10, 5000
				});
		
		for (Emp emp : list) {
			System.out.println(emp.getEmpname());
		}
		
		
	}

	@Override
	public int executeDML(String sql, Object[] params) {
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

	@Override
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

	@Override
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
	

	@Override
	public int delete(Object obj) {
		Class<?> c = obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(c);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey(); // 获得主键
		
		// 通过反射机制，调用属性对应的get set方法
		Object priKeyValue = ReflectUtils.invokeGet(onlyPriKey.getName(), obj);
		delete(c, priKeyValue);
		
		return 0;
	}

	@Override
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

	@Override
	public List queryRows(String sql, Class clz, Object[] params) {
		Connection conn = DBManager.getConn();
		List list = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			
			// 给sql设参
			JDBCUtils.handleParams(ps, params);
			System.out.println(ps);
			rs = ps.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			// 多行
			while(rs.next()) {
				if (list==null) {
					list = new ArrayList();
				}
				
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
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(rs, ps, conn);
		}
		
		return list;
	}

	@Override
	public Object queryUniqueRow(String sql, Class clz, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object queryValue(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number queryNumber(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

}













