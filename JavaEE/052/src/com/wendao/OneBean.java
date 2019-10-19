package com.wendao;

public class OneBean {
	int a;
	Object o;
	
	public OneBean() {
		// TODO Auto-generated constructor stub
	}

	public OneBean(int a, Object o) {
		super();
		this.a = a;
		this.o = o;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}

	@Override
	public String toString() {
		return "OneBean [a=" + a + ", o=" + o + "]";
	}
	
	
	
	
	
}
