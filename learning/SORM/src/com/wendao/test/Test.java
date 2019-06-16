package com.wendao.test;

import java.util.List;

import com.wendao.sorm.core.Query;
import com.wendao.sorm.core.QueryFactory;
import com.wendao.vo.EmpVO;

/**
 * test for client
 * @author china
 *
 */
public class Test {
	public static void main(String[] args) {
		Query q = QueryFactory.createQuery();
		
		String sql = "select e.id,e.empname,e.salary+e.bonus 'income',e.age,"
				+ "d.dname 'deptName',d.address 'deptAddr' "
				+ "from emp e join dept d on e.deptId=d.id;";
		List<EmpVO> list = q.queryRows(sql, EmpVO.class, null);
		
		for (EmpVO e : list) {
			System.out.println(e.getEmpname()+" \t"+e.getDeptName());
		}
		
	}
}
