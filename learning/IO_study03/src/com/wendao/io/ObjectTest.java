package com.wendao.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Object Stream
 * 
 * 1. write , then read
 * 2. the sequence must be identical
 * 3. must implements Serializable
 * 
 * ObjectOutputStream
 * ObjectInputSteam
 * @author china
 *
 */
public class ObjectTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// write out 序列化
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(
									new BufferedOutputStream(baos));
		
		// operate
		oos.writeUTF("我爱学习"); // 写 字符串
		oos.writeInt(18);
		oos.writeBoolean(true);
			// write obj
		oos.writeObject("编码大法好");
		oos.writeObject(new Date());
		oos.writeObject(new Employee("anna", 10000));
		
		oos.flush();
		byte[] datas = baos.toByteArray(); 
		
		// read
		ObjectInputStream ois = new ObjectInputStream(
									new BufferedInputStream(
										new ByteArrayInputStream(datas)));
		// 反序列化
		String msg = ois.readUTF();
		int age = ois.readInt();
		boolean flag = ois.readBoolean();
		Object str = ois.readObject(); // 无论用不用这个数据，都要按照顺序读取出来
		Object date = ois.readObject();
		Object emp = ois.readObject();
		
		System.out.println(msg);
		System.out.println(age);
		System.out.println(flag);
		
		if (str instanceof String) {
			String strObj = (String)str;
			System.out.println(strObj);
		}
		if (date instanceof Date) {
			Date dateObj = (Date)date;
			System.out.println(dateObj);
		}
		if (emp instanceof Employee) {
			Employee empObj = (Employee)emp;
			System.out.println(empObj.getName() + ", "+empObj.getSalary());
		}
		
		
		
		
		
		
		
		
		
		
		
	}
}

// javabean 封装数据
class Employee implements Serializable{
	private transient String name; // transient，指该数据不需要序列化
	private double salary;
	
	public Employee() {
		
	}
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
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
	
	
}











