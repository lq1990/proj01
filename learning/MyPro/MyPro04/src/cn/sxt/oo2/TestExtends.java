package cn.sxt.oo2;

/**
 * test ผฬณะ
 * @author china
 *
 */
public class TestExtends {
	public static void main(String[] args) {
		Student s = new Student();
		s.rest();
		
		Student s2 = new Student("beta", 20, "CS");
		
		System.out.println(s2 instanceof Student);
		System.out.println(s2 instanceof Person);
		System.out.println(s2 instanceof Object);
	}
}


class Person /* extends Object */ {
	String name;
	int height;
	
	public void rest() {
		System.out.println("I take a rest");
	}
}

class Student extends Person {
	String major;
	
	public void study () {
		System.out.println("study for 2 hours");
	}
	
	public Student(String name, int height, String major) {
		this.name = name;
		this.height = height;
		this.major = major;
	}
	
	public Student() {
		
	}
}
