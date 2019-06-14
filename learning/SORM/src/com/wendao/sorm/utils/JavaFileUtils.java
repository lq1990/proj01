package com.wendao.sorm.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wendao.sorm.bean.ColumnInfo;
import com.wendao.sorm.bean.JavaFieldGetSet;
import com.wendao.sorm.bean.TableInfo;
import com.wendao.sorm.core.DBManager;
import com.wendao.sorm.core.MySqlTypeConvertor;
import com.wendao.sorm.core.TableContext;
import com.wendao.sorm.core.TypeConvertor;

/**
 * 生成java文件（源代码）常用操作
 * 
 * @author china
 *
 */
public class JavaFileUtils {

	/**
	 * 针对一个 field。
	 * 根据字段信息生成java属性信息。如：varchar username --> private String username, set get
	 * 
	 * @param column    字段信息
	 * @param convertor 类型转化器
	 * @return java属性和set get 源码
	 */
	public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column, TypeConvertor convertor) {
		JavaFieldGetSet jfgs = new JavaFieldGetSet();

		String javaFieldType = convertor.databaseType2JavaType(column.getDataType());

		jfgs.setFieldInfo("\tprivate " + javaFieldType + " " + column.getName() + ";\n");

		// public String getUsername(){return username}
		StringBuilder getSrc = new StringBuilder();
		getSrc.append("\tpublic " + javaFieldType + " get" + StringUtils.firstChar2UpperCase(column.getName()) + " () {"
				+ "\n" + "\t\treturn " + column.getName() + "; \n" + "\t}\n");
		jfgs.setGetInfo(getSrc.toString());

		// public String setUsername(String username){this.username=username;}
		StringBuilder setSrc = new StringBuilder();
		setSrc.append("\tpublic void set"+StringUtils.firstChar2UpperCase(column.getName())+" (");
		setSrc.append(javaFieldType+" "+column.getName()+") {\n");
		setSrc.append("\t\tthis."+column.getName()+" = "+column.getName()+";\n");
		setSrc.append("\t}\n");
		
		jfgs.setSetInfo(setSrc.toString());

		return jfgs;
	}

	/**
	 * 根据表信息生成java类的源代码
	 * 
	 * @param tableInfo 表信息
	 * @param convertor 数据类型转化器
	 * @return java类的源代码
	 */
	public static String createJavaSrc(TableInfo tableInfo, TypeConvertor convertor) {
		
		// 将数据库的字段 转为 java属性
		Map<String, ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();
		for(ColumnInfo c : columns.values()) {
			javaFields.add(createFieldGetSetSRC(c, convertor));
		}
		
		StringBuilder src = new StringBuilder();

		// 生成 package 语句
		src.append("package "+ DBManager.getConf().getPoPackage()+";\n\n");
		
		// 生成import语句
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n\n");
		
		// 生成类声明语句 public class X {
		src.append("public class "+StringUtils.firstChar2UpperCase(tableInfo.getTname()) + " {\n\n");
		
		// 生成 属性列表
		for(JavaFieldGetSet f:javaFields) {
			src.append(f.getFieldInfo());
		}
		src.append("\n\n");
		
		// get
		for(JavaFieldGetSet f:javaFields) {
			src.append(f.getGetInfo());
		}
		src.append("\n\n");
		
		// set
		for(JavaFieldGetSet f:javaFields) {
			src.append(f.getSetInfo());
		}
		src.append("\n\n");
		
		// 生成类结束
		src.append("}\n");
		
//		System.out.println(src.toString());
		return src.toString();
	}
	
	
	public static void createjavaPOFile(TableInfo tableInfo, TypeConvertor convertor) {
		// 拿到源码
		String src = createJavaSrc(tableInfo, convertor);
		
		String srcPath = DBManager.getConf().getSrcPath()+"/";
		String poPath = DBManager.getConf().getPoPackage().replaceAll("\\.", "/"); // regex java 一个杠变两个杠
		
		File f = new File(srcPath+poPath);
		
		if (!f.exists()) { // 若指定目录不存在，则帮助用户建立
			f.mkdirs();
		}
		
		// write into com.wendao.po
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(
					new FileWriter(
							new File(f.getAbsolutePath() + "/" + StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java")));
			bw.write(src);
			bw.flush();
			System.out.println("建立表: "+tableInfo.getTname()+
					" -> 对应的java类: "+StringUtils.firstChar2UpperCase(tableInfo.getTname())+".java");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != bw) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
//		ColumnInfo ci = new ColumnInfo("id", "int", 1);
//		JavaFieldGetSet jfgs = createFieldGetSetSRC(ci, new MySqlTypeConvertor());
//		System.out.println(jfgs);
		
		TypeConvertor convertor = new MySqlTypeConvertor();
		Map<String, TableInfo> mp = TableContext.tables;
		
		for (TableInfo ti : mp.values()) {
			// db表 转成 com.wendao.po.Clz 
			createjavaPOFile(ti, convertor);
			
		}
		
	}
	
}






































