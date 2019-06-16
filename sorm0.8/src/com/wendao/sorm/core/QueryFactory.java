package com.wendao.sorm.core;

/**
 *  创建Query对象的工厂类。
 *  工厂类本身是 单例模式。
 *  同时，采用原型模式，使用 clone，提高效率
 *  
 * @author china
 *
 */
public class QueryFactory {
	
	private static QueryFactory factory = new QueryFactory();
	private static Class c;
	private static Query prototypeObj; 
		// 原型对象。在static init时就生成了。在使用时，使用 clone即浅拷贝。
	
	static {
		// 加载TableContext，使类信息、表信息进来
		System.out.println(TableContext.class);
		
		
		
		try {
			c = Class.forName(DBManager.getConf().getQueryClass());
			prototypeObj = (Query) c.newInstance(); // 静态init时，就生成了。
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private QueryFactory() {
		
	}
	

	public static Query createQuery() {
		
		try {
			return (Query) prototypeObj.clone();// 浅克隆
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		} 
		
//		try {
//			return (Query) c.newInstance();
//			// 缺点：使用反射去构造实例，效率低。
//			// 改进方法：使用克隆
//			
//		} catch (InstantiationException | IllegalAccessException e) {
//			e.printStackTrace();
//			return null;
//		}
	}
	
}















