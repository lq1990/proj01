package com.wendao.pojo;

import java.util.List;

public class Demo {
	private List<People> peo;
	
	public Demo() {
		// TODO Auto-generated constructor stub
	}
	

	public Demo(List<People> peo) {
		super();
		this.peo = peo;
	}



	public List<People> getPeo() {
		return peo;
	}

	public void setPeo(List<People> peo) {
		this.peo = peo;
	}

	@Override
	public String toString() {
		return "Demo [peo=" + peo + "]";
	}
	
	



	
}
