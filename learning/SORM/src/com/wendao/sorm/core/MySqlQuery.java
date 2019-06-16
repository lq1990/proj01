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
import com.wendao.vo.EmpVO;

public class MySqlQuery extends Query {
	
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
	
	@SuppressWarnings("unchecked")
	public static void testQueryRows() {
		List<Emp> list = new MySqlQuery().queryRows("select id,empname,age from emp where age>? and salary>?", 
				Emp.class, 
				new Object[] {
						10, 5000
				});
		
		for (Emp emp : list) {
			System.out.println(emp.getEmpname());
		}
		
		System.out.println();
		
		// 复杂查询时，可以封装 vo  javabean对象，将查询的结果保存。sql语句中使用的别名和vo对象中属性对应。
		String sql2 = 
				"select e.id,e.empname,salary+bonus 'income',"+
				"e.age,d.dname 'deptName',d.address 'deptAddr'"+ 
			" from emp e join dept d on e.deptId=d.id";
		List<EmpVO> list2 = new MySqlQuery().queryRows(sql2,
				EmpVO.class, 
				null);
		
		for (EmpVO e : list2) {
			System.out.println(e.getEmpname()+"\t "+e.getIncome()+"\t "+e.getDeptName());
		}
	}
	
	
	public static void main(String[] args) {
		Number obj = new MySqlQuery().queryNumber("select count(*) from emp where salary>=?", new Object[] {
				10000
		});
		System.out.println(obj.intValue());
		
//		testQueryRows();
		
		
		
		
		
	}

	@Override
	public Object queryPaginate(int pageNum, int size) {
		return null;
	}

}











































