package test;

import java.util.List;

import com.wendao.sorm.core.Query;
import com.wendao.sorm.core.QueryFactory;
import com.wendao.test.po.Emp;
import com.wendao.test.vo.EmpVO;

public class Test {
	
	public static void add() {
		Emp e = new Emp();
		e.setAge(19);
		e.setEmpname("玲玲");
		e.setSalary(2000.0);
		
		Query q = QueryFactory.createQuery();
		q.insert(e);
	}
	
	public static void delete(){
		Emp e = new Emp();
		e.setId(2);
		
		Query q = QueryFactory.createQuery();
		q.delete(e);
		
	}
	
	public static void update() {
		Emp e = new Emp();
		e.setAge(1000);
		e.setId(1);
		e.setSalary(19999.0);
		
		Query q = QueryFactory.createQuery();
		q.update(e, new String[] {"age","salary"});
		
		
	}
	
	public static void select01() {
		Query q = QueryFactory.createQuery();
		Number n = (Number) q.queryNumber(
				"select count(*) from emp where salary>?", 
				new Object[] {1000});
		System.out.println(n);
		
	}
	
	public static void select02() {
		Query q = QueryFactory.createQuery();
		Emp e = (Emp) q.queryUniqueRow("select * from emp where id=?", Emp.class, new Object[] {1});
		System.out.println(e.getEmpname()+"\t"+e.getSalary());
		
	}
	
	public static void select03() {
		Query q = QueryFactory.createQuery();
		List<Emp> list = q.queryRows("select * from emp where id>?", Emp.class, new Object[] {3});
		for (Emp e : list) {
			System.out.println(e.getId()+"\t"+e.getEmpname()+"\t"+e.getSalary()+"\t"+e.getBirthday());
		}
		
	}
	
	public static void select04() {
		Query q = QueryFactory.createQuery();
		String sql = "select e.id,e.empname,e.age,d.dname 'deptName',d.address 'deptAddr'"
				+ " from emp e join dept d on d.id=e.deptId";
		
		@SuppressWarnings("unchecked")
		List<EmpVO> list = q.queryRows(sql, EmpVO.class, new Object[] {});
		for (EmpVO e : list) {
			System.out.println(
					e.getId()+"\t"+
					e.getEmpname()+"\t"+
					e.getDeptName()+"\t"+
					e.getDeptAddr());
		}
	}
	
	public static void select05() {
		Query q = QueryFactory.createQuery();
		Emp e = (Emp) q.queryById(Emp.class, 1);
		System.out.println(e.getEmpname());
		
	}
	
	public static void main(String[] args) {
		
		// 通过这个方法可以生成po类。
//		TableContext.updateJavaPOFile();
		
//		select01();
		
//		delete();
		
//		update();
		
//		select02();
		
		select05();
		
		
	}
}
