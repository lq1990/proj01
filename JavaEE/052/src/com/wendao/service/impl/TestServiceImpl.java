package com.wendao.service.impl;

import com.wendao.service.TestService;

public class TestServiceImpl implements TestService {

	@Override
	public void test(String msg) {
		System.out.println("接口实现类TestServiceImpl.test(), "+msg);
		
	}

}
