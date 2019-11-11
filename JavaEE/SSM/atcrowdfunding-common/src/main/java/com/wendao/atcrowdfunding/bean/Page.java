package com.wendao.atcrowdfunding.bean;

import java.util.List;

/**
 * 	使用泛型T，
 * 	User, 角色 等等都可以
 * @author china
 *
 * @param <T>
 */
public class Page<T> {
	private List<T> datas;
	private int pageno; // 当前页
	private int totalno; // 总页面
	private int totalsize; // 总条数
	
	public Page() {
		// TODO Auto-generated constructor stub
	}

	public Page(List<T> datas, int pageno, int totalno, int totalsize) {
		super();
		this.datas = datas;
		this.pageno = pageno;
		this.totalno = totalno;
		this.totalsize = totalsize;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public int getPageno() {
		return pageno;
	}

	public void setPageno(int pageno) {
		this.pageno = pageno;
	}

	public int getTotalno() {
		return totalno;
	}

	public void setTotalno(int totalno) {
		this.totalno = totalno;
	}

	public int getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}

	@Override
	public String toString() {
		return "Page [datas=" + datas + ", pageno=" + pageno + ", totalno=" + totalno + ", totalsize=" + totalsize
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datas == null) ? 0 : datas.hashCode());
		result = prime * result + pageno;
		result = prime * result + totalno;
		result = prime * result + totalsize;
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
		Page other = (Page) obj;
		if (datas == null) {
			if (other.datas != null)
				return false;
		} else if (!datas.equals(other.datas))
			return false;
		if (pageno != other.pageno)
			return false;
		if (totalno != other.totalno)
			return false;
		if (totalsize != other.totalsize)
			return false;
		return true;
	}
	
	
	
}
