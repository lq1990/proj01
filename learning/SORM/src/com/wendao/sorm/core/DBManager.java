package com.wendao.sorm.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.wendao.sorm.bean.Configuration;

/**
 * 	根据配置文件，维持连接对象的管理（增加连接池功能）
 * @author china
 *
 */
public class DBManager {
	
	private static Configuration conf;
	
	static {
		Properties pros = new Properties();
		
		try {
			pros.load(
					Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		conf = new Configuration();
		conf.setDriver(pros.getProperty("driver"));
		conf.setPoPackage(pros.getProperty("poPackage"));
		conf.setPwd(pros.getProperty("pwd"));
		conf.setSrcPath(pros.getProperty("srcPath"));
		conf.setUrl(pros.getProperty("url"));
		conf.setUser(pros.getProperty("user"));
		conf.setUsingDB(pros.getProperty("usingDB"));
	
	}
	
	public static Connection getConn() {
		try {
			Class.forName(conf.getDriver());
			return DriverManager.getConnection(
					conf.getUrl(), conf.getUser(), conf.getPwd());
			// 目前先直接建立连接，后期增加连接池处理，提高效率！！！
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 返回conf，共外部使用
	 * @return
	 */
	public static Configuration getConf() {
		return conf;
	}
	
	public static void close(AutoCloseable...autoCloseables) {
		for (AutoCloseable autoCloseable : autoCloseables) {
			if (null != autoCloseable) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}




















