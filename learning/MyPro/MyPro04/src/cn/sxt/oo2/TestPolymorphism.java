package cn.sxt.oo2;

/**
 * 
 * @author china
 *
 */
public class TestPolymorphism {
	public static void main(String[] args) {
		Animal a = null;
		a = new Animal();
		System.out.println(a);
		animalCry(a);
		
		Animal d = new Dog(); // 自动向上转型
		System.out.println(d);
		animalCry(d);
		
		Animal c = new Cat();
		
		Dog d2 = (Dog) d; // 强制向下转型
		d2.door();
		
		Dog d3 = (Dog) c;
		d3.door();
		
		String s;
	}
	
	static void animalCry(Animal a) {
		a.shout();
	}
}

class Animal {
	
	public void shout() {
		System.out.println("叫了一声");
	}
}

class Dog extends Animal {
	public void shout() {
		System.out.println("汪汪汪");
	}
	
	public void door() {
		System.out.println("看门");
	}
}

class Cat extends Animal {

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("喵喵喵");
	}
	
}
