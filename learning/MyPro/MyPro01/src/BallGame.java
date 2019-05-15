
import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame {

	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.png");

	double x = 100; // 小球的横坐标
	double y = 100; // 小球的纵坐标
	boolean right = true; // 方向

	// 画窗口的方法。注：由于img懒加载，窗口显示后，先最小化，再最大化即可显示img了。
	public void paint(Graphics g) {
		System.out.println("窗口被画了一次！");
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int) x, (int) y, null);

		if (right) {
			x = x + 20;
		} else {
			x = x - 20;
		}
		
		if(x>= (1209-53-35)) { // 因为图是以左上角为原点定位，需减去球的35
			right = false;
		}
		if (x <= 53) {
			right = true;
		}

	}

	// 窗口加载
	void launchFrme() {
		setSize(1209, 611); // 窗口width，height
		setLocation(50, 50); // 窗口坐标
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
		System.out.println("ball game main");

		BallGame game = new BallGame();
		game.launchFrme();

	}

}
