package cn.bjsxt.oop.abstractClass;

public abstract class Animal {
	String str;
	public abstract void run();
	public void breath() {
		System.out.println("ºôÎü");
		this.run();
	}
	
	public Animal() {
		
	}
	
}

class Cat extends Animal {
	
	@Override
	public void run() {
		System.out.println("Ã¨²½Ğ¡ÅÜ");
	}
	
}

class Dog extends Animal {

	@Override
	public void run() {
		System.out.println("¹·ÅÜ");
	}
	
}
