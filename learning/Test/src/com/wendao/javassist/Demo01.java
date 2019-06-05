package com.wendao.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;

/**
 * 
 * use javassist to generate a new class like Emp
 * 
 * @author china
 *
 */
public class Demo01 {
	public static void main(String[] args) throws Exception {
		// 1. get pool
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.makeClass("com.wendao.bean.Emp2");
		
		// create field
		CtField f1 = CtField.make("private int no;", cc);
		CtField f2 = CtField.make("private String name;", cc);
		cc.addField(f1);
		cc.addField(f2);
		
		// create method
		CtMethod m1 = CtMethod.make("public int getNo(){return no;}", cc);
		CtMethod m2 = CtMethod.make("public void setNo(int no){this.no = no;}", cc);
		cc.addMethod(m1);
		cc.addMethod(m2);
		
		// add constructor
		CtConstructor con = 
				new CtConstructor(new CtClass[] {CtClass.intType, pool.get("java.lang.String")}, cc);
		con.setBody("{this.no = no; this.name = name;}");
		cc.addConstructor(con);
		
		// 将构建好的类写入到dir中
		cc.writeFile("D:/myGithub/myJava/learning/Test/src/");
		System.out.println("over");
		
		
	}
}


















