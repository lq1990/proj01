package cn.sxt.game;

import java.awt.Graphics;
import java.awt.Image;

public class Explode {
	double x, y;
	
	static Image[] imgs = new Image[6]; 
	// static 变量，只初始化一次。当有多个对象要爆炸时，不必多次new
	static {
		for(int i=0;i<6;i++) {
			imgs[i] = GameUtil.getImage("images/explode/e0"+(i+1)+".png");
			imgs[i].getWidth(null);
		}
	}
	
	int count;
	
	public void draw(Graphics g) {
		if(count <=5) {
			int w = imgs[count].getWidth(null);
			int h = imgs[count].getHeight(null);
			g.drawImage(imgs[count], (int)(x-w/2), (int)(y-h/2), null);
			count++;
		}
	}
	
	public Explode(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
