package com.wendao.service;

import com.wendao.pojo.PageInfo;

/**
 * 	业务逻辑 相关fn，在Service中完成
 * @author china
 *
 */
public interface StudentService {
	
	PageInfo showPage(String sname, String tname, 
			String pageSize, String pageNumber);
	
	
	
}
