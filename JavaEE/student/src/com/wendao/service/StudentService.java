package com.wendao.service;

import com.wendao.pojo.PageInfo;

public interface StudentService {
	
	PageInfo showPage(String sname, String tname, String pageSize, String pageNumber);
	
	
}
