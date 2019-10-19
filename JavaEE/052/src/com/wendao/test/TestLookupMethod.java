package com.wendao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLookupMethod {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		CommandManager manager = ac.getBean("manager", CommandManager.class);
		
		System.out.println(manager.getClass().getName());
		//manager.process();
		
		
	}
}

/**
 * 抽象类
 * @author china
 *
 */
abstract class CommandManager {
	public void process() {
		MyCommand cmd = createCommand();
		
		System.out.println(cmd);
	}
	
	/**
	 * 可通过spring的lookup-method动态实现此抽象方法
	 * 
	 * @return
	 */
	protected abstract MyCommand createCommand();
}

interface MyCommand {
}

class MyCommand1 implements MyCommand {
	public MyCommand1() {
		System.out.println("MyCommand1.MyCommand1()");
	}
}

class MyCommand2 implements MyCommand {
	public MyCommand2() {
		System.out.println("MyCommand2.MyCommand2()");
	}
}












