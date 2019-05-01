package cn.sxt.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
	boolean left, up, right, down;
	boolean live = true;
	
	public void drawSelf(Graphics g) {
		if (live) {
			g.drawImage(img, (int)this.x, (int)y, null);
			if (left) {
				x -= speed;
			}
			if (right) {
				x += speed;
			}
			if (up) {
				y -= speed;
			}
			if (down) {
				y += speed;
			}
		} else {
//			System.out.println("飞机坠毁！");
			
//			Color c = g.getColor();
//			g.setColor(Color.WHITE);
//			g.setFont(new Font(Font.SERIF, Font.BOLD, 50));
//			g.drawString("飞机失事！", 120, 250);
//			
//			g.setColor(c);
		}
		
	}
	
	public Plane(Image img, double x, double y) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = 5;
		this.width = img.getWidth(null); 
		this.height = img.getHeight(null);
	}
	
	
	// press时，增加响应方向
	public void addDirection(KeyEvent e) {
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT: // 37
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default:
			break;
		}
	}
	
	// release键，取消响应方向
	public void minusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT: // 37
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default:
			break;
		}
	}
	
	
	
}
