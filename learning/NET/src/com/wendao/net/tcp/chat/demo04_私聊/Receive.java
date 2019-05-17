package com.wendao.net.tcp.chat.demo04_私聊;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 接收线程
 * @author china
 *
 */
public class Receive implements Runnable {

	private DataInputStream dis; // 输入流
	private boolean isRunning = true;
	
	/**
	 * @param dis
	 */
	public Receive(Socket socket) {
		super();
		try {
			this.dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
//			e.printStackTrace();
			this.isRunning = false;
			CloseUtil.closeAll(dis);
		}
	}

	/**
	 * 接收数据
	 * @return
	 */
	public String receive() {
		String msg = "";
		try {
			msg = dis.readUTF();
		} catch (IOException e) {
			this.isRunning = false;
			CloseUtil.closeAll(dis);
		}
		
		return msg;
	}

	@Override
	public void run() { // 线程体
		while (isRunning) {
			System.out.println(this.receive());
		}
	}

}
