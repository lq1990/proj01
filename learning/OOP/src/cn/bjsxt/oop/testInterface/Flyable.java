package cn.bjsxt.oop.testInterface;

public interface Flyable {
	int MAX_SPEED = 11000;
	int MIN_HEIGHT = 1;
	void fly();
}

interface Attack {
	void attack();
}

class Plane implements Flyable {

	@Override
	public void fly() {
		System.out.println("飞机飞");
	}
}

class Man implements Flyable {

	@Override
	public void fly() {
		System.out.println("跳起来飞");
	}
	
}

class Stone implements Flyable, Attack {
	int weight;
	
	@Override
	public void fly() {
		System.out.println("被扔出去飞");
	}

	@Override
	public void attack() {
		System.out.println("石头攻击");
	}
	
}


