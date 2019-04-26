
/**
 * test 参数传值机制
 * @author china
 *
 */
public class User4 {
	int id;
	String name;
	String pwd;
	
	public User4(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public void testParamTransfer(User4 u) {
		u.name = "anna";
	}
	
	public void testParamTransfer2(User4 u) {
		// u1 进行值传递，地址拷贝给u
		u = new User4(200, "lq"); // 创建新对象，地址变化了。对原u1内容不影响。
		// 运行到此处时，u的指向地址将不再和 u1一样，u的改变不影响u1
		
	}
	
	
	public static void main(String[] args) {
		User4 u1 = new User4(100, "beta");
		System.out.println(u1.name);
		u1.testParamTransfer(u1); 
		// 动态方法中传的值是一个对象，虽然是值传递，故传的是 对象的地址
		System.out.println(u1.name);
		
		u1.testParamTransfer2(u1); 
		// u1地址拷贝给fn中，虽然fn中u地址改变，但u1地址不变，因此u1.name 不变
		System.out.println(u1.name);
	}
	
}
