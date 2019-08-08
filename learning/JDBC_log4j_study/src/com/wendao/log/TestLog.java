package com.wendao.log;

import org.apache.log4j.Logger;

public class TestLog {
	// 1. 获取log4j对象
	public static Logger logger = Logger.getLogger(TestLog.class);
	
	
	public static void main(String[] args) {
		System.out.println("test log main...");
		
		logger.debug("我是 debug");
		logger.info("i am info");
		logger.warn("i am warn");
		logger.error("i am error");
		logger.fatal("i am fatal");
		
		
	}
	
	
}
