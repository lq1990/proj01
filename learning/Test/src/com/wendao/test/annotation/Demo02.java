package com.wendao.test.annotation;

@MyAnnotation01
public class Demo02 {
	
	@MyAnnotation01(age=10, stuName="Anna", 
			schools="wd", id=1001)
	public void test() {
		
	}
	
	@MyAnnotation02(value="")
	public void test02() {
		// 若属性只有value时，（）中的value可省略
	}

}
