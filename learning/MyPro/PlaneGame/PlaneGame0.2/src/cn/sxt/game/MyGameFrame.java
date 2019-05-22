package cn.sxt.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * 飞机游戏的主窗口
 * @author china
 *
 */
public class MyGameFrame extends JFrame {
	
	Image ball = GameUtil.getImage("images/ball.png");
	
	@Override
	public void paint(Graphics g) { // 自动被调用，g相当于一支画笔
		Font f = g.getFont();
		Color c = g.getColor();
		g.setColor(Color.BLUE); // 设置颜色时，会全局影响g
		
		g.drawLine(100, 100, 300, 300);
		g.drawRect(100, 100, 300, 300);
		g.drawOval(100, 100, 300, 300);
		g.fillRect(100, 100, 40, 40);
		g.setColor(Color.red);
		g.setFont(new Font(Font.SERIF, Font.BOLD, 50));
		
		g.drawString("我是谁？", 200, 200);
		g.drawImage(ball, 250, 250, null);
		
		
		g.setColor(c); // 还原最原始的颜色
		g.setFont(f);
	} 
	
	/**
	 * init frame
	 */
	public void launchFrame() {
		this.setTitle("我的游戏");
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocation(300, 300);
		
		// 当手动关闭窗口时，可以使 terminate
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 0表示正常结束
			}
		});
	}
	
	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}
}
