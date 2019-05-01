package cn.sxt.oo;

import cn.sxt.oo2.*;

public class TestEncapsulation2 {
	public static void main(String[] args) {
		Human h = new Human();
		h.sayAge();
	}
}

class Girl extends Human {
	void sayHi() {
		System.out.println(height);
	}
}