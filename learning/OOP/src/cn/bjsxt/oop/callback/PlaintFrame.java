package cn.bjsxt.oop.callback;


public class PlaintFrame {
	public static void drawFrame(IMyFrame f) {
		System.out.println("启动线程");
		System.out.println("增加循环");
		System.out.println("查看消息栈");
		
		// 画窗口，此处为一个 Callback或称 Hook，调用外部的类 实现不同的功能
		f.paint();
		
		System.out.println("增加缓存，提高效率");
		
		
		/*
		 * 以上的步骤，模板方法模式。有固定的部分，也有灵活可变的
		 */
	}
	
	
	
	public static void main(String[] args) {
		drawFrame(new GameFrame02());
	}
}


class GameFrame01 /*extends MyFrame */ implements IMyFrame {
	public void paint() {
		System.out.println("GameFrame01.paint()");
		System.out.println("画窗口");
	} 
}

class GameFrame02 implements IMyFrame {
	public void paint() {
		System.out.print("GameFrame02.paint()");
		System.out.println(" 画窗口");
	} 
}