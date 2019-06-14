package com.wendao.sorm.bean;

/**
 * javabean.
 * 
 * 	封装表中一个字段 field 的信息
 * @author china
 * @version 0.0.1
 *
 */
public class ColumnInfo {
	
	/**
	 * name of field
	 */
	private String name;
	
	private String dataType;
	
	/**
	 *  字段的键类型
	 *  0：普通键
	 *  1：主键
	 *  2：外键
	 *  
	 */
	private int keyType;
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public int getKeyType() {
		return keyType;
	}

	public void setKeyType(int keyType) {
		this.keyType = keyType;
	}

	/**
	 * @param name
	 * @param dataType
	 * @param keyType
	 */
	public ColumnInfo(String name, String dataType, int keyType) {
		super();
		this.name = name;
		this.dataType = dataType;
		this.keyType = keyType;
	}
	
	public ColumnInfo() {
	}
	
}














