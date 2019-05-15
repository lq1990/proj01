
import java.awt.*;
import javax.swing.*;

public class BallGame2 extends JFrame {

	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");

	double x = 100; // 小球的横坐标
	double y = 100; // 小球的纵坐标
	
	double degree = 3.14/3; // 弧度 单位

	// 画窗口的方法。注：由于img懒加载，窗口显示后，先最小化，再最大化即可显示img了。
	public void paint(Graphics g) {
		System.out.println("窗口被画了一次！");
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int) x, (int) y, null);
		
		x = x + 20*Math.cos(degree);
		y = y + 20*Math.sin(degree);
		
		// 碰到上下边界
		if (y >= 611-53-35 || y <= 53) {
			degree = -degree;
		}
		
		// 碰到左右边界
		if (x < 53 || x > 1209-53-35 ) {
			degree = 3.14 - degree;
		}
	}

	// 窗口加载
	void launchFrme() {
		setSize(1209, 611); // 窗口width，height
		setLocation(53, 53); // 窗口坐标
		setVisible(true);

		// 重画窗口，每秒画25次
		while (true) {
			repaint();
			try {
				Thread.sleep(40); // 40ms
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// main
	public static void main(String[] args) {
		System.out.println("ball game2 main");

		BallGame2 game = new BallGame2();
		game.launchFrme();

	}

}
