package com.wendao.sorm.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectUtils {

	/**
	 * 调用 obj对象的属性fieldName的 get方法
	 * @param fieldName
	 * @param obj
	 * @return
	 */
	public static Object invokeGet(String fieldName, Object obj) {
		// 通过反射机制，调用属性对应的get set方法
		try {
			Class c = obj.getClass();
			Method m = c.getDeclaredMethod("get" + StringUtils.firstChar2UpperCase(fieldName), null);
			// getMethod 是获得public的方法，而getDeclaredMethod可以获得所有方法
			return m.invoke(obj, null);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public static void invokeSet(Object obj, String columnName, Object columnValue) {
		try {
			Method m = obj.getClass().getDeclaredMethod(
					"set"+StringUtils.firstChar2UpperCase(columnName), 
					columnValue.getClass());
			m.invoke(obj, columnValue);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
}
