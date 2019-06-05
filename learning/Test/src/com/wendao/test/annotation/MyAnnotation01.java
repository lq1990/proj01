package com.wendao.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation01 {
	
	// 参数类型 参数名
	String stuName() default "";
	int age() default 0;
	int id() default -1; // 负数通常表示：不存在，类似于indexOf为-1
	
	String[] schools() default {"wendao", "chupin"};
	
}
