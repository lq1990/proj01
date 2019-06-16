package com.wendao.sorm.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.wendao.sorm.bean.Configuration;
import com.wendao.sorm.connpool.DBConnPool;

/**
 * 	根据配置文件，维持连接对象的管理（增加连接池功能）
 * @author china
 *
 */
public class DBManager {
	
	/**
	 * 	连接池对象
	 */
	private static DBConnPool pool; // 此处不能直接new一个DBConnPool，static初始化相互冲突了
	
	/**
	 *  配置信息
	 */
	private static Configuration conf;
	
	static {
		// static init，只要使用DBConnPool这个类，就会init static
		
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
		conf.setQueryClass(pros.getProperty("queryClass"));
		conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));
		conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));
		
		
	
	}
	
	/**
	 * 获得Connection对象。
	 * 
	 * @return
	 */
	public static Connection getConn() {
		// 从pool中取conn，而非重新create
		if (pool == null) {
			pool = new DBConnPool();
		}
		return pool.getConnection();
	}
	
	/**
	 *  创建新的Connection对象
	 * @return
	 */
	public static Connection createConn() {
		
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
	
	/**
	 * 	关闭诸如ResultSet, PreparedStatement, Connection 等实现Autocloseable接口的类对象
	 * @param autoCloseables
	 */
	public static void close(AutoCloseable...autoCloseables) {
		for (AutoCloseable autoCloseable : autoCloseables) {
			if (autoCloseable instanceof Connection) {
				if (null != autoCloseable) {
					// 并非真正的关闭，而是将conn重放回pool，复用。
					pool.close((Connection) autoCloseable);
				}
				
			} else {
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
	
	
}




















