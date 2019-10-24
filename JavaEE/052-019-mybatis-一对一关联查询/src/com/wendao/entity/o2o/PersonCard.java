package com.wendao.entity.o2o;

import java.io.Serializable;

public class PersonCard implements Serializable {

	private Integer id;
	private String name;
	private String cardNo;
	private String address;
	
	private Person person; // 关联一个人
	
	public PersonCard() {
		// TODO Auto-generated constructor stub
	}

	public PersonCard(Integer id, String name, String cardNo, String address, Person person) {
		super();
		this.id = id;
		this.name = name;
		this.cardNo = cardNo;
		this.address = address;
		this.person = person;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "PersonCard [id=" + id + ", name=" + name + ", cardNo=" + cardNo + ", address=" + address + ", person="
				+ person + "]";
	}

	/**
	 * 重写hashCode, equals，主要是当使用 HashTable HashSet去存储类实例时，当多个实例的属性值相等时，则会当成同一个元素.
	 * 	不重写的话，默认继承Object，以地址判断是否相等，那每new一个实例就是一个新的对象
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
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
		PersonCard other = (PersonCard) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}
	
	
	
	
	
}
