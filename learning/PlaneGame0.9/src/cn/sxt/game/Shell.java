package cn.sxt.game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 炮弹类
 * 
 * @author china
 *
 */
public class Shell extends GameObject {
	double degree;

	public Shell() {
		x = 200;
		y = 200;
		width = 10;
		height = 10;
		speed = 3;

		degree = Math.random() * Math.PI * 2;
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);

		g.fillOval((int) x, (int) y, width, height);

		x += speed * Math.cos(degree);
		y += speed * Math.sin(degree);

		
		// 因为矩形炮弹画时，左上角为相对原点
		if (x < 0 || x > Constant.GAME_WIDTH - this.width) {
			degree = Math.PI - degree;
		}

		if (y < 0+40 /*标题栏 高度*/ || y > Constant.GAME_HEIGHT-this.height) {
			degree = -degree;
		}

		g.setColor(c);
	}

}
