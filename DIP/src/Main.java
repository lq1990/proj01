
public class Main {

	public static void main(String[] args) {
		System.out.println("this is Dependence Inversion Principle main method");
		new Mother().read(new Newspaper());
		new Mother().read(new Book());
	}

}
