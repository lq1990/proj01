package com.wendao.service;

import java.io.IOException;

import com.wendao.pojo.Account;

public interface AccountService {
	/**
	 * 是public static final
	 */
	int ACCOUNT_PWD_NOT_MATCH = 1; 
	
	/**
	 * 余额不足
	 */
	int ACCOUNT_BALANCE_NOT_ENOUGH = 2; 
	
	/**
	 * 账号与payee不符
	 */
	int ACCOUNT_NAME_NOT_MATCH = 3; 
	
	/**
	 * 	转账失败
	 */
	int ERROR = 4;
	
	/**
	 * 	转账成功
	 */
	int SUCCESS = 5;
	
	/**
	 * 	转账
	 * @param accIn 收款
	 * @param accOut 转出
	 * @return
	 * @throws IOException 
	 */
	int transfer(Account accIn, Account accOut) throws IOException;
	
	
}
