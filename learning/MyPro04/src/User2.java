
/**
 * test static 
 * @author china
 *
 */
public class User2 {
	int id;
	String name;
	String pwd;
	
	static String company = "wendao";
	
	public User2(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void login() {
		printCompany(); // 动态可用静态
		System.out.println(company);
		System.out.println("login: "+this.name);
	}
	
	public static void printCompany() {
		// login(); // 静态不能用动态的
		System.out.println(company);
	}
	
	public static void main(String[] args) {
		User2 u = new User2(101, "anna");
		u.login();
//		User2.printCompany();
//		User2.company = "chupin";
//		User2.printCompany();
	}
}
