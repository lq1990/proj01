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
	
	Image plane = GameUtil.getImage("images/plane_small.png");
	Image bg = GameUtil.getImage("images/bg.png");
	
	int planeX = 250;
	int planeY = 250;
	
	@Override
	public void paint(Graphics g) { // 自动被调用，g相当于一支画笔
		System.out.println("paint");
		
		g.drawImage(bg, 0, 0, null);
		g.drawImage(plane, planeX, planeY, null);
		planeX++;
		
	}
	
	private Image offScreenImage = null;
	public void update(Graphics g) {
		System.out.println("update");
		if(offScreenImage == null) {
			offScreenImage = this.createImage(500, 500);
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	
	/*
	 * 帮助我们反复的重画窗口。
	 *  定义内部类。可以方便使用  MyGameFrame类中的属性方法
	 */
	class PaintThread extends Thread {
		
		@Override
		public void run() {
			while (true) {
				System.out.println("repaint once");
				repaint();
				
				try {
					Thread.sleep(40); // 40ms, 即 1s内25个图片
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
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
		
		new PaintThread().start(); // 启动重画窗口的线程
		
	}
	
	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}
}


