package com.wendao.pojo;

import net.sf.cglib.proxy.Enhancer;

/**
 * 	cglib 动态代理
 * 	需要 cglib.jar, asm.jar
 * 
 * @author china
 *
 */
public class Client {
	public static void main(String[] args) {
		Enhancer en = new Enhancer();
		en.setSuperclass(Laozong.class);
		en.setCallback(new Mishu());
		
		Laozong lz = (Laozong) en.create();
		lz.chifan();
		
	}
}
