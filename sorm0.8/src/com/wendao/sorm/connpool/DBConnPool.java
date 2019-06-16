package com.wendao.sorm.connpool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wendao.sorm.core.DBManager;

/**
 * 	连接池的类
 * @author china
 *
 */
public class DBConnPool {
	
	/**
	 *  连接池对象
	 */
	private List<Connection> pool;
	
	/**
	 * 最大连接数
	 */
	private static final int POOL_MAX_SIZE = DBManager.getConf().getPoolMaxSize();
	
	/**
	 * 最小连接数
	 */
	private static final int POOL_MIN_SIZE = DBManager.getConf().getPoolMinSize();

	
	/**
	 * 	初始化连接池，使池中的连接数达到最小值
	 */
	public void initPool() {
		if (null == pool) {
			pool = new ArrayList<Connection>();
		}
		
		while(pool.size() < POOL_MIN_SIZE) {
			pool.add(DBManager.createConn());
			System.out.println("init conn pool, size: "+pool.size());
		}
	}
	
	/**
	 * 	从连接池中取出一个连接，
	 * 	使用同步方法，避免多线程问题
	 * @return
	 */
	public synchronized Connection getConnection() {
		int last_index = pool.size()-1;
		Connection conn = pool.get(last_index);
		pool.remove(last_index); // conn被取出使用时，要从list中remove
		
		return conn;
	}

	/**
	 * 	并非真正的关闭，
	 * 	而是将连接放回到pool中。
	 * @param autoCloseable
	 */
	public synchronized void close(Connection autoCloseable) {
		if (pool.size() >= POOL_MAX_SIZE) {
			try {
				if (null != autoCloseable) {
					autoCloseable.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			// 因为设置了pool的上限数量，只有未到上限时，才将使用后的conn回到pool中。
			pool.add(autoCloseable);
		}
		
	}
	
	
	public DBConnPool() {
		initPool();
	}
	
}











































