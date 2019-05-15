package cn.sxt.oo2;

public class TestEquals {
	public static void main(String[] args) {
		Object obj;
		String str;
		
		User u1 = new User(1000, "anna", "212121");
		User u2 = new User(1000, "beta", "123456");
		
		System.out.println(u1==u2);
		System.out.println(u1.equals(u2));
		
		String str1 = new String("sxt");
		String str2 = new String("sxt");
		System.out.println("str1 == str2 : "+ (str1 == str2));
		System.out.println("str1 equals str2 : "+ (str1.equals(str2)));
	}
}

class User {
	int id;
	String name;
	String pwd;
	
	public User(int id, String name, String pwd) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	@Override
	public boolean equals(Object obj) {
//		System.out.println(obj.getClass()); // class cn.sxt.oo2.User
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}