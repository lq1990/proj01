package com.wendao.atcrowdfunding.bean;

public class User {
	private Integer id;
	private String username;
	private String loginacct;
	private String pwd;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	
	public User(Integer id, String username, String loginacct, String pwd) {
		super();
		this.id = id;
		this.username = username;
		this.loginacct = loginacct;
		this.pwd = pwd;
	}



	public String getLoginacct() {
		return loginacct;
	}


	public void setLoginacct(String loginacct) {
		this.loginacct = loginacct;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", loginacct=" + loginacct + ", pwd=" + pwd + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((loginacct == null) ? 0 : loginacct.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loginacct == null) {
			if (other.loginacct != null)
				return false;
		} else if (!loginacct.equals(other.loginacct))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	
	
}
