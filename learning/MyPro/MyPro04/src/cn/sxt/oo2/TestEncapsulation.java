package cn.sxt.oo2;

/**
 * 
 * @author china
 *
 */
public class TestEncapsulation {
	public static void main(String[] args) {
		Human h = new Human();
//		h.sayAge();
		h.name = "anna";
		h.height = 180;
		
		
		Person4 p4 = new Person4();
		p4.setAge(-14);
		System.out.println(p4.getAge());
		
	}
}


class Boy extends Human {
	void sayHello() {
		System.out.println(this.name);
	}
}
