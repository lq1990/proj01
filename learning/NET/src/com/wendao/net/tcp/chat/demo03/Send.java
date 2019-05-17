package com.wendao.net.tcp.chat.demo03;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 从console接收数据后，
 * 发送数据。
 * 线程
 * 
 * @author china
 *
 */
public class Send implements Runnable {
	private BufferedReader console; // 控制台 输入流
	private DataOutputStream dos; // 管道输出流
	private boolean isRunning = true; // 控制线程的标识

	/**
	 * @param console
	 * @param dos
	 */
	public Send(Socket socket) {
		super();
		this.console = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			this.dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
//			e.printStackTrace();
			this.isRunning = false;
			CloseUtil.closeAll(dos, console);
		}
	}
	
	/**
	 * 从console接收数据
	 * @return
	 */
	private String getMsgFromConsole() {
		try {
			return console.readLine();
		} catch (IOException e) {
//			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 发送数据
	 */
	public void send() {
		
		String msg = getMsgFromConsole();
		
		if (msg != null && !msg.equals("")) {
			try {
				dos.writeUTF(msg);
				dos.flush(); // 记住，write之后要flush，强制刷新
			} catch (IOException e) {
				this.isRunning = false;
				CloseUtil.closeAll(dos, console);
			}
		}
	}

	@Override
	public void run() {
		// 线程体
		while (isRunning) {
			send();
		}
	}

}











