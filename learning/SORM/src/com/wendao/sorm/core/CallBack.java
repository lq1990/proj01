package com.wendao.sorm.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 	回调函数接口。
 * 	不同的fn中，实现这个接口，有不同的功能。
 * @author china
 *
 */
public interface CallBack {
	
	
	public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs);
	
	
}
