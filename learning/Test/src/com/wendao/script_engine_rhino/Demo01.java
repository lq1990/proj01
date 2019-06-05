package com.wendao.script_engine_rhino;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * <pre>
 * test script engine
 * 
 * run javascript by using Rhino
 * 
 * </pre>
 * 
 * @author china
 *
 */
public class Demo01 {
	public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
		// =========== 1. get engine ============
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("js");

		// ============ 2. code. ================
		// def a var，会存储到引擎上下文里
		engine.put("msg", "today is a good day.");
		System.out.println(engine.get("msg"));

		String str = "var user = {name:'wendao12', age: 16};";
		str += "print(user.name);";

		
		// 执行脚本
		engine.eval(str);
		engine.eval("msg = 'this uni is good.'");
		System.out.println(engine.get("msg"));

		
		// def fn
		engine.eval("function add(a,b){return a+b;}");
		// get interface
		Invocable jsInvoke = (Invocable) engine;
		// 执行
		Object res = jsInvoke.invokeFunction("add", new Object[] {13,20});
		System.out.println(res);
		
		// 导入其它java包，使用其它包中的java类
		String jsCode 
		= "var Arrays = Java.type('java.util.Arrays'); var list = Arrays.asList([\"学校\", \"大学\"])";
		engine.eval(jsCode);
		List<String> list2 = (List<String>) engine.get("list");
		for (String string : list2) {
			System.out.println(string);
		}
		
		System.out.println();
		// 执行一个js文件，将js文件放到src下即可。本质上会在bin下
		URL url = Demo01.class.getClassLoader().getResource("a.js");
		FileReader fr = new FileReader(url.getPath());
		engine.eval(fr);
		fr.close();
		
		
	}
}

















