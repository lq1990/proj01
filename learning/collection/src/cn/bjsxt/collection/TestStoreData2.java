package cn.bjsxt.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 测试表格数据的存储
 * 每行数据使用 javabean对象存储，多行使用map或list存储
 * @author china
 *
 */
public class TestStoreData2 {
	public static void main(String[] args) {
		User u1 = new User(1001, "anna", 20000, "2018.5.5");
		User u2 = new User(1002, "beta", 30000, "2017.8.5");
		User u3 = new User(1003, "cello", 40000, "2016.6.5");
		User u4 = new User(1004, "delta", 50000, "2015.4.5");
		
		// use list
		List<User> list = new ArrayList<>();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);
		
		for(User u : list) {
			System.out.print(u.getId() + ", "+u.getName() + ", "
					+u.getSalary() + ", "+u.getHiredate());
			System.out.println();
			
		}
		
		System.out.println("#########################");
		// use map
		Map<Integer, User> map = new HashMap<>();
		map.put(1, u1);
		map.put(-42, u4);
		map.put(-22, u2);
		map.put(3, u3);
		
		Set<Integer> keyset = map.keySet();
		for(Integer key : keyset) {
			System.out.println(key + " : "+map.get(key));
			
		}
	}
}

class User {
	private int id;
	private String name;
	private double salary;
	private String hiredate;
	
	
	// 一个完整的javabean，要有set和get方法，以及无参构造器
	public User() {
		
	}
	
	@Override
	public String toString() {
		return ""+id+", "+name+", "+salary+", "+hiredate;
	}
	
	public User(int id, String name, double salary, String hiredate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.hiredate = hiredate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

}
