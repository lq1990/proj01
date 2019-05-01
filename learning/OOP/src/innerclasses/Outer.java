package innerclasses;

public class Outer {
	public static void main(String[] args) {
		Face f = new Face();
		
		Face.Nose n = f.new Nose(); // 非静态内部类的new
		n.breath();
		
		Face.Ear e = new Face.Ear(); // 静态内部类的 new
		e.listen();
	}
}



class Face {
	int type;
	String shape = "瓜子脸";
	static String color = "红润";
	
	
	/**
	 *  内部类从属于 外部类对象，内部类不能使用static
	 * @author china
	 *
	 */
	class Nose {
		String type;
		void breath() {
			System.out.println(shape);
			System.out.println(Face.this.type);
			System.out.println("呼吸");
		}
	}
	
	static class Ear {
		void listen() { 
			System.out.println(color); // 静态内部类 可以访问外部类的静态属性
			System.out.println("我在听");
		}
	}
}
