package cn.bjsxt.oop.polymorphism.myServlet;

public class HttpServlet {
	public void service() {
		System.out.println("HttpServlet.service()");
		this.doGet(); // this 指代最终 new出来的 子类对象
	}
	
	public void doGet() {
		System.out.println("HttpServlet.doGet()");
		
	}
	
}
