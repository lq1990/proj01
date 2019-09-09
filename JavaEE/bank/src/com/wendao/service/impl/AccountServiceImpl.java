package com.wendao.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.wendao.pojo.Account;
import com.wendao.pojo.Log;
import com.wendao.service.AccountService;


/**	
 * 	ServiceImpl中写 业务。
 * 	而针对db的成为事务。
 * 
 * 	此Service提供给控制器：
 * 	方法：transfer();
 * @author china
 *
 */
public class AccountServiceImpl implements AccountService {

	@Override
	public int transfer(Account accIn, Account accOut) throws IOException {
		// session get
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(is);
		SqlSession ss = fac.openSession();
		
		// 先判断账号与密码是否匹配
		Account accOutSel = ss.selectOne("com.wendao.mapper.AccountMapper.selByAccnoPwd", accOut);
		if(accOutSel != null) {
			if(accOutSel.getBalance() >= accOut.getBalance()) {
				// 确认收款人信息
				Account accInSel =  ss.selectOne("com.wendao.mapper.AccountMapper.selByAccnoName", accIn);
				if(accInSel != null) {
					// 可以转
					accIn.setBalance(accOut.getBalance()); // 转账金额
					
					// 先把 accOut 减
					accOut.setBalance(-accOut.getBalance());
					int idx = ss.update("com.wendao.mapper.AccountMapper.updBalanceByAccno", accOut);
					
					// 再 accIn 增
					idx += ss.update("com.wendao.mapper.AccountMapper.updBalanceByAccno", accIn);
					if(idx == 2) {
						// 成功后，记录log。往db的log表中增加记录
						Log log = new Log();
						log.setAccOut(accOut.getAccno());
						log.setAccIn(accIn.getAccno());
						log.setMoney(accIn.getBalance());
						ss.insert("com.wendao.mapper.LogMapper.inslog", log);
						
						// log4j
						Logger logger = Logger.getLogger(AccountServiceImpl.class);
						logger.info(log.getAccOut()+" 给 "+log.getAccIn()+" 在"+new Date().toLocaleString()+" 转账 "+log.getMoney());
						
						ss.commit();
						ss.close();
						return SUCCESS;
					} else {
						ss.rollback();
						ss.close();
						return ERROR;
					}
					
				} else {
					return ACCOUNT_NAME_NOT_MATCH;
				}
				
			} else {
				// 余额不足
				return ACCOUNT_BALANCE_NOT_ENOUGH;
				
			}
			
		} else {
			// 失败
			return ACCOUNT_PWD_NOT_MATCH;
		}
	}

}










