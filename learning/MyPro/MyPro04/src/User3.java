
/**
 * test 静态初始化块的使用
 * @author china
 *
 */
public class User3 {
	int id;
	String name;
	String pwd;
	static String company;
	
	// 在类的初始化时 执行
	static {
		System.out.println("执行类的初始化工作");
		company = "wendao";
		printCompany();
		
	}
	
	public static void printCompany() {
		System.out.println(company);
	}
	
	public static void main(String[] args) {
		User3 u = null;
	}
}
