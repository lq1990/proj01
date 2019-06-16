package com.wendao.sorm.core;

/**
 * 	负责java数据类型和数据库类型的互相转换
 * 
 * @author china
 *
 */
public interface TypeConvertor {
	
	/**
	 * 	将数据库类型转成java的数据类型
	 * @param columnType
	 * @return
	 */
	public String databaseType2JavaType(String columnType);
	
	
	/**
	 * 	将java数据类型转换成数据库数据类型
	 * @param javaType
	 * @return 数据库数据类型
	 */
	public String javaType2DatabaseType(String javaType);
	
	
}
