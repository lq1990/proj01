package com.wendao.pojo;

public class MiShu implements Gongneng {
	private Laozong laozong = new Laozong("云云");

	@Override
	public void zhidingxiaomubiao() {
		System.out.println("预约时间");
		
		laozong.zhidingxiaomubiao();
		
		System.out.println("把访客信息备注");
		
	}

	@Override
	public void chifan() {
		// TODO Auto-generated method stub
		System.out.println("预约时间");
		laozong.chifan();
		
		System.out.println("把访客信息备注");
	}
	
	
}
