package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import server.util.CloseUtil;

/**
 * 请求并响应。
 * 
 * 当前使用到的 Servlet, ServletContext, Dispatcher, WebApp等有 Tomcat原型了
 * 
 * @author china
 *
 */
public class Server {
	private ServerSocket server;
	public static final String CRLF = "\r\n";
	public static final String BLANK = " ";
	
	private boolean isShutDown = false;

	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}

	/**
	 * 启动方法
	 */
	public void start() {
		this.start(9999);
	}

	public void start(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("--- server is running, listening to port "+
					port+" ---\r\n");
			
			this.receive();
			
		} catch (IOException e) {
			this.stop();
		}
	}
	
	/**
	 * 接收客户端
	 */
	private void receive() {
		try {
			// 连接多个client
			while (!isShutDown) {
				new Thread(new Dispatcher(this.server.accept())).start();
			}
			
		} catch (IOException e) {
//			e.printStackTrace();
			this.stop();
		}
	}

	/**
	 * 停止服务器
	 */
	public void stop() {
		this.isShutDown = true;
		CloseUtil.closeAll(server);
	}
}
