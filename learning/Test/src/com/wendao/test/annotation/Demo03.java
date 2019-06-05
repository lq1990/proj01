package com.wendao.test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 
 * 有了注解后，需要写：注解信息处理流程
 * 
 * 使用`反射`读取注解的信息，模拟处理 注解信息的处理流程
 * 
 * @author china
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		
		try {
			Class<?> clz = Class.forName("com.wendao.test.annotation.SxtStudent");
			// clz 对象包含了SxtStudent类全部的信息
			
			// 获得类的所有有效注解
			Annotation[] annos = clz.getAnnotations();
			for (Annotation a : annos) {
				System.out.println(a);
			}
			
			
			// 获得`类`的指定注解
			SxtTable st = (SxtTable) clz.getAnnotation(SxtTable.class);
			System.out.println(st.value());
			
			// 获得类的`属性`的注解
			Field f = clz.getDeclaredField("stuName"); // 先拿到属性
			SxtField sf = f.getAnnotation(SxtField.class);
			System.out.println(sf.columnName()+", "+sf.type()+", "+sf.length());
			
			
			
			// 根据获得的 表名、字段的信息 拼出 DDL(data definition language)语句，
			// 然后使用JDBC执行这个SQL，在数据库中生成相应的表
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}






