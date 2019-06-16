package com.wendao.sorm.core;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.wendao.sorm.bean.ColumnInfo;
import com.wendao.sorm.bean.TableInfo;
import com.wendao.sorm.utils.JavaFileUtils;
import com.wendao.sorm.utils.StringUtils;

/**
 * 注：此个类，直接粘贴使用
 * 
 * <pre>
 * 框架初始化时，负责获取管理db所有表结构和类结构的关系， 
 * 并可以根据`表结构`生成`类结构`。
 * </pre>
 * @author china
 *
 */
public class TableContext {

	/**
	 * key: 表名 value: 表信息对象
	 */
	public static Map<String, TableInfo> tables = new HashMap<String, TableInfo>();

	/**
	 * 将po的`class对象`和`表信息对象`关联起来，便于重用
	 */
	public static Map<Class, TableInfo> poClassTableMap = new HashMap<Class, TableInfo>();

	private TableContext() {
	}

	static {
		// 项目启动时，调用static init
		
		try {
			// 初始化获得表的信息
			Connection conn = DBManager.getConn();
			java.sql.DatabaseMetaData dbmd = conn.getMetaData();

			ResultSet tableRS = dbmd.getTables(null, "%", "%", new String[] { "TABLE" });

			while (tableRS.next()) {
				String tableName = (String) tableRS.getObject("TABLE_NAME");
				TableInfo ti = new TableInfo(tableName, new ArrayList<ColumnInfo>(), new HashMap<String, ColumnInfo>());
				tables.put(tableName, ti);

				// 查询表中的所有字段
				ResultSet set = dbmd.getColumns(null, "%", tableName, "%");
				while (set.next()) {
					ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"), set.getString("TYPE_NAME"), 0);
					ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
				}

				ResultSet set2 = dbmd.getPrimaryKeys(null, "%", tableName);
				while (set2.next()) {
					ColumnInfo ci2 = (ColumnInfo) ti.getColumns().get(set2.getObject("COLUMN_NAME"));
					ci2.setKeyType(1); // set pri key
					ti.getPriKeys().add(ci2);
				}
				if (ti.getPriKeys().size() > 0) {
					// 取唯一主键。方便使用。若是联合主键，则为空
					ti.setOnlyPriKey(ti.getPriKeys().get(0));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 根据表结构，更新 配置的po包下面的java类。
		updateJavaPOFile();
		
		// 完善 poClassTableMap。即加载po包下面的所有的类，便于重用。
		loadPOTables();
		
	}

	/**
	 * 根据表结构，更新 配置的po包下面的java类。
	 */
	public static void updateJavaPOFile() {
		TypeConvertor convertor = new MySqlTypeConvertor();
		Map<String, TableInfo> mp = TableContext.tables;
		
		for (TableInfo ti : mp.values()) {
			// db表 转成 com.wendao.po.Clz 
			JavaFileUtils.createjavaPOFile(ti, convertor);
		}
	}
	
	/**
	 * 加载po包下面的类
	 */
	public static void loadPOTables() {
		
		for(TableInfo ti : tables.values()) {
			try {
				
				Class<?> c = Class.forName(DBManager.getConf().getPoPackage()
						+"."+
						StringUtils.firstChar2UpperCase(ti.getTname()));
				poClassTableMap.put(c, ti);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}		
		
		
	}
	
	public static void main(String[] args) {
		Map<String, TableInfo> tables = TableContext.tables;
		System.out.println(tables);
	}
	
}





























