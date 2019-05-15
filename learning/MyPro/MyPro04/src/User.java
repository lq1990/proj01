/**
 * constructor overload
 * @author china
 *
 */
public class User {

	int id;
	String name;
	String pwd;
	
	public User() {
		
	}
	
	public User(int id, String name) {
		this.id = id; // this 表示创建好的对象
		this.name = name;
	}
	
	public User(int id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	
	public static void main(String[] args) {
		User u1 = new User();
		User u2 = new User(101, "anna");
		User u3 = new User(102, "beta", "mima111");
		
	}
}
