/**
 * 
 * @author china
 *
 */
public class TestThis {

	int a, b, c;
	TestThis(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	TestThis(int a, int b, int c){
		this(a, b); // 指的 调用一个构造器
		this.c = c;
	}
	
	void sing() {
		
	}
	
	void eat() {
		this.sing();
		System.out.println("吃饭");
	}
	
	public static void main(String[] args) {
		TestThis hi = new TestThis(2, 3);
		hi.eat();
		
		
	}
}
