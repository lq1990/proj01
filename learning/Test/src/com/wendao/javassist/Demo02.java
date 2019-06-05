package com.wendao.javassist;

import java.lang.reflect.Method;
import java.util.Arrays;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

/**
 * test javassist API
 * 
 * 操作javassist和反射类似
 * 
 * @author china
 *
 */
public class Demo02 {

	/**
	 * manipulate basic usage of class
	 * 
	 * @throws Exception
	 */
	public static void testClass() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.wendao.javassist.Emp");

		byte[] bytes = cc.toBytecode(); // to byteCode
		System.out.println(Arrays.toString(bytes));

		System.out.println(cc.getName());
		System.out.println(cc.getSimpleName());
		System.out.println(cc.getSuperclass());
		System.out.println(cc.getInterfaces());

	}

	/**
	 * test basic use of method
	 * 
	 * @throws Exception
	 */
	public static void testMethod() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.wendao.javassist.Emp");

		// create method type 1
//		CtMethod m = CtNewMethod.make("public int add(int a, int b){return a+b;}", cc);

		// create method type 2
		CtMethod m = new CtMethod(CtClass.intType, "add", new CtClass[] { CtClass.intType, CtClass.intType }, cc);
		m.setModifiers(javassist.Modifier.PUBLIC);
		m.setBody("{System.out.println(\"this is Emp.add().\");return $1+$2;}");
		// $1, $2 对应前两个参数。$0对应this
		cc.addMethod(m);

		// ========= 通过反射调用新生成的方法 ===========
		Class<?> clz = cc.toClass();
		Object obj = clz.newInstance(); // 调用了Emp的无参构造
		Method clzM = clz.getDeclaredMethod("add", int.class, int.class);
		Object res = clzM.invoke(obj, 200, 300);
		System.out.println("res: " + res);

		// 说明到此为止，动态添加方法 成功了

	}

	/**
	 * AOP, Aspect Oriented Programming
	 * 
	 * before/after/around
	 * 
	 * @throws Exception
	 */
	public static void test03() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.wendao.javassist.Emp");

		CtMethod cm = cc.getDeclaredMethod("sayHello", new CtClass[] { CtClass.intType });
		// 加到方法体 前面
		cm.insertBefore("System.out.println($1);System.out.println(\"start.\");");

		// 加到方法体 后面
		cm.insertAfter("System.out.println(\"after\");");
		
		// ========= 通过反射调用新生成的方法 ===========
		Class<?> clz = cc.toClass();
		Object obj = clz.newInstance(); // 调用了Emp的无参构造
		Method clzM = clz.getDeclaredMethod("sayHello", int.class);
		Object res = clzM.invoke(obj, 222);
		
	}
	
	/**
	 * field
	 * @throws Exception 
	 */
	public static void test04() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.wendao.javassist.Emp");
		
//		CtField f1 = CtField.make("private int salary;", cc);
		
		CtField f2 = new CtField(CtClass.intType, "salary", cc);
		f2.setModifiers(javassist.Modifier.PRIVATE);
		cc.addField(f2, "1001"); // second param: default val
		
//		CtField f = cc.getDeclaredField("no");
		
		cc.addMethod(CtNewMethod.getter("getSalary", f2));
		cc.addMethod(CtNewMethod.setter("setSalary", f2));
		
		// ====== 后续可通过反射调用 ======
		
	}
	
	/**
	 * test constructor
	 * @throws Exception 
	 * 
	 */
	public static void test05() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.wendao.javassist.Emp");
		
		CtConstructor[] cs = cc.getConstructors();
		for (CtConstructor ctConstructor : cs) {
			System.out.println(ctConstructor.getLongName());
		}
		
	}
	
	/**
	 * Annotation
	 * @throws Exception 
	 */
	public static void testAnno() throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.wendao.javassist.Emp");
		Object[] all = cc.getAnnotations();
//		System.out.println(all.length);
//		for (Object o : all) {
//			System.out.println(o);
//		}
		
		Author a = (Author)all[0];
		String name = a.name();
		int year = a.year();
		System.out.println(name+", "+year);
		
		
	}

	public static void main(String[] args) throws Exception {
		testAnno();
		
	}
	
	
	
}


















