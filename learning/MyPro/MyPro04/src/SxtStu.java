
// 一个 .java文件内可有多个class，但最多只能有一个 public class
public class SxtStu {

	// 属性 fields，若只有属性没有方法 则为结构体
	int id;
	String name;
	int age;

	Computer comp;

	// methods
	void study() {
		System.out.println("study..., using " + comp.brand);
	}

	void play() {
		System.out.println("play...");
	}

	// 无参的构造方法，会默认生成。可人为不写。
	public SxtStu() {
		// TODO Auto-generated constructor stub

	}

	// main
	public static void main(String[] args) {
		SxtStu stu = new SxtStu();
		System.out.println(stu);
		
		stu.id = 1001;
		stu.name = "lq";
		stu.age = 22;
		
		Computer c1 = new Computer();
		System.out.println(c1);
		c1.brand = "lenovo";
		
		stu.comp = c1;
		
		stu.play();
		stu.study();
		
	}

}

class Computer {
	String brand;
}
