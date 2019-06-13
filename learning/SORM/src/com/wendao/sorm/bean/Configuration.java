package com.wendao.sorm.bean;

/**
 * 	管理配置信息
 * @author china
 *
 */
public class Configuration {
	/**
	 * 	驱动类
	 */
	private String driver;
	
	/**
	 * jdbc的url
	 */
	private String url;
	
	/**
	 * db的用户名
	 */
	private String user;
	
	/**
	 * db的密码
	 */
	private String pwd;
	
	/**
	 * 正在使用的数据库
	 */
	private String usingDB;
	
	/**
	 * 项目的源码路径
	 */
	private String srcPath;
	
	/**
	 * 扫描生成java类的包（po：persistance object 持久化对象）
	 */
	private String poPackage;
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUsingDB() {
		return usingDB;
	}
	public void setUsingDB(String usingDB) {
		this.usingDB = usingDB;
	}
	public String getSrcPath() {
		return srcPath;
	}
	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
	public String getPoPackage() {
		return poPackage;
	}
	public void setPoPackage(String poPackage) {
		this.poPackage = poPackage;
	}
	
	public Configuration() {
	}
	
	/**
	 * @param driver
	 * @param url
	 * @param user
	 * @param pwd
	 * @param usingDB
	 * @param srcPath
	 * @param poPackage
	 */
	public Configuration(String driver, String url, String user, String pwd, String usingDB, String srcPath,
			String poPackage) {
		super();
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pwd = pwd;
		this.usingDB = usingDB;
		this.srcPath = srcPath;
		this.poPackage = poPackage;
	}
	
}
