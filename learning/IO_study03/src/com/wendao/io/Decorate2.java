package com.wendao.io;

/**
 * 模拟coffee
 * 1. 抽象组件：需要装饰的抽象对象，接口或抽象父类
 * 2. 具体组件：需要装饰的对象
 * 3. 抽象装饰类：包含了对抽象组件的引用，以及装饰着共有的方法
 * 4. 具体装饰类：被装饰的对象
 * @author china
 *
 */
public class Decorate2 {
	public static void main(String[] args) {
		Drink coffee = new Coffee();
		Drink sugar = new Sugar(coffee);
//		System.out.println("price: "+sugar.cost()+", info: "+sugar.info());
//		Drink milk = new Milk(coffee);
//		System.out.println("price: "+milk.cost()+", info: "+milk.info());
		
		Drink milksugar = new Milk(sugar);
		System.out.println("price: "+milksugar.cost()+", info: "+milksugar.info());
		
	}
}

// 抽象组件
interface Drink{
	double cost();
	String info();
}

// 具体组件
class Coffee implements Drink {

	private String name = "原味咖啡";
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return name;
	}
}

// 抽象装饰类
abstract class Decorate implements Drink {
	
	private Drink drink;
	
	public Decorate(Drink drink) {
		this.drink = drink;
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.drink.cost();
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return this.drink.info();
	}
}

// 具体装饰类
class Milk extends Decorate {

	public Milk(Drink drink) {
		super(drink);
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
//		System.out.println("milk: "+super.cost()+20);
		return super.cost()+20;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+" add milk";
	}
}

class Sugar extends Decorate {
	
	public Sugar(Drink drink) {
		super(drink);
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		System.out.println("sugar: "+super.cost()+10);
		return super.cost()+10;
	}
	
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+" add sugar";
	}
}


