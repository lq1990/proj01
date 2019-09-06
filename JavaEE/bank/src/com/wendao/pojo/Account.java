package com.wendao.pojo;

public class Account {
	private int id;
	private String accno;
	private int password;
	private String name; // 收款人
	private double balance; // 余额
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int id, String accno, int password, String name, double balance) {
		super();
		this.id = id;
		this.accno = accno;
		this.password = password;
		this.name = name;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accno=" + accno + ", password=" + password + ", name=" + name + ", balance="
				+ balance + "]";
	}

	

	
	
}
