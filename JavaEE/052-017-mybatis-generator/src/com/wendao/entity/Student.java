package com.wendao.entity;

public class Student {
    private Integer id;

    private String name;

    private Integer age;

    private Integer tid;

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
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", tid=" + tid + "]";
	}
    
    
}