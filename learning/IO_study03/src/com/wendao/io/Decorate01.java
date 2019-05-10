package com.wendao.io;

/**
 * 实现 放大器 对声音的放大功能
 * @author china
 *
 */
public class Decorate01 {
	public static void main(String[] args) {
		Person p = new Person();
		p.say();
		
		Amplifier am = new Amplifier(p);
		am.say();
	}
	
}

interface Say{
	void say();
}

class Person implements Say{
	// field
	private int voice = 10;

	@Override
	public void say() {
		System.out.println("voice: "+this.getVoice());
	}

	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}
	
}

class Amplifier implements Say{
	private Person p;
	
	public Amplifier(Person p) {
		this.p = p;
	}
	
	@Override
	public void say() {
		System.out.print("voice: " + p.getVoice()*100);
		System.out.println(" noise");
	}
}












