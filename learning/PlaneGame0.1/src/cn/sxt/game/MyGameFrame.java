package cn.sxt.game;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/**
 * 飞机游戏的主窗口
 * @author china
 *
 */
public class MyGameFrame extends JFrame {
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
