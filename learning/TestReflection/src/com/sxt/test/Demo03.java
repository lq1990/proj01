package com.sxt.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.sxt.test.bean.User;

/**
 * 
 * 	通过反射API动态的操作：构造器、方法、构造器
 * 
 * @author china
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		// 动态操作构造器
		String path = "com.sxt.test.bean.User";
		
		try {
			Class<User> clz = (Class<User>) Class.forName(path);
			
			// 通过反射API动态调用构造方法，构造对象
			User u = clz.newInstance(); // 调用了User的无参构造方法
			System.out.println(u);
			
			Constructor<User> c = clz.getDeclaredConstructor(int.class, int.class, String.class);
			User u2 = c.newInstance(1001, 18, "anna");
			
			System.out.println(c);
			System.out.println(u2.getId());
			
			// 通过反射API调用普通方法。通过反射看起来麻烦，但是method名也是String，可以动态加载
			User u3 = clz.newInstance();
			u3.setUname("beta"); // 常规方法
			System.out.println(u3.getUname());
			Method method = clz.getDeclaredMethod("setUname", String.class); // 通过反射
			method.invoke(u3, "cello");
			System.out.println(u3.getUname()); 
			
			// 通过反射API操作属性
			User u4 = clz.newInstance();
			Field f = clz.getDeclaredField("uname");
			f.setAccessible(true); // 因为f属性为private，需要设置
			f.set(u4, "delta");
			System.out.println(u4.getUname());
			System.out.println(f.get(u4));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
