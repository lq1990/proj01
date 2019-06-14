package com.wendao.sorm.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装了JDBC查询常用的utils
 * 
 * @author china
 *
 */
public class JDBCUtils {

	/**
	 * 给sql设参
	 * @param ps 预编译sql语句对象
	 * @param params 参数
	 */
	public static void handleParams(PreparedStatement ps, Object[] params) {
		// ps = conn.preparedStatement(sql); params对应于sql中 ？
		
		if (null != params) {
			for (int i = 0; i < params.length; i++) {
				// sql 中 ? 的位置都要 set参
				try {
					ps.setObject(1 + i, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
