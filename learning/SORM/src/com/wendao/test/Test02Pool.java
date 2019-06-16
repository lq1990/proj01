package com.wendao.test;

import java.util.List;

import com.wendao.sorm.core.Query;
import com.wendao.sorm.core.QueryFactory;
import com.wendao.vo.EmpVO;

/**
 * 测试pool效率
 * 
 * @author china
 *
 */
public class Test02Pool {
	
	public static void test01() {
		Query q = QueryFactory.createQuery();

		String sql = "select e.id,e.empname,e.salary+e.bonus 'income',e.age,"
				+ "d.dname 'deptName',d.address 'deptAddr' " + "from emp e join dept d on e.deptId=d.id;";
		List<EmpVO> list = q.queryRows(sql, EmpVO.class, null);

		for (EmpVO e : list) {
			System.out.println(e.getEmpname() + " \t" + e.getDeptName());
		}
	}
	
	public static void main(String[] args) {
		Long begin = System.currentTimeMillis();
		for (int i = 0; i < 3000; i++) {
			test01();
		}
		
		System.out.println();
		System.out.println("time needed: "+(System.currentTimeMillis() - begin)+"ms");
		// 3000: 15.509s, 1.32s(use pool)
		
	}
	
}
