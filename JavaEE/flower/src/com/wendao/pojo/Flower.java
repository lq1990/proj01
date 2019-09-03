package com.wendao.pojo;

public class Flower {
	private int id;
	private String name;
	private double price;
	private String production;
	
	public Flower() {
		// TODO Auto-generated constructor stub
	}

	public Flower(int id, String name, double price, String production) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.production = production;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProduction() {
		return production;
	}

	public void setProduction(String production) {
		this.production = production;
	}

	@Override
	public String toString() {
		return "Flower [id=" + id + ", name=" + name + ", price=" + price + ", production=" + production + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((production == null) ? 0 : production.hashCode());
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
		Flower other = (Flower) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (production == null) {
			if (other.production != null)
				return false;
		} else if (!production.equals(other.production))
			return false;
		return true;
	}
	
	
	
}
