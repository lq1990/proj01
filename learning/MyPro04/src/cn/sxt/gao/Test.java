package cn.sxt.gao;

import cn.sxt.oo.*; 
// 若导入某个包内所有的类，会降低编译速度，但不影响运行速度。

import java.util.Date;
import java.sql.*;

import static java.lang.Math.*; // 静态导入，导入后可以直接使用Math类下的静态属性

public class Test {
	public static void main(String[] args) {
		User user = new User();
		
		java.util.Date date = new Date();
		
		System.out.println(Math.PI);
		System.out.println(PI);
	}
}
