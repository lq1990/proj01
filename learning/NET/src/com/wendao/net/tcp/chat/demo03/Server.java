package com.wendao.net.tcp.chat.demo03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * server 输入输出 两个线程
 * 
 * @author china
 *
 */
public class Server {
	// 容器装所有client，方便管理
	private List<MyChannel> all = new ArrayList<Server.MyChannel>();
	
	public static void main(String[] args) throws IOException {
		System.out.println("--- server is running... ---");
		
		new Server().connect();

	}
	
	public void connect() throws IOException {
		// 1.
		ServerSocket server = new ServerSocket(8989);
		
		while (true) {
			Socket socket = server.accept(); // 一个accept一个client
			
			MyChannel channel = new MyChannel(socket);
			all.add(channel); // 将所有client加入到容器中，方便管理
			new Thread(channel).start(); // 一条道路
			
			// 当有多个client时，如何管理呢？ 》》》使用容器
			
		}
		
	}

	/**
	 * 一个client，一条路径
	 * 
	 * 1. 输入流，接收数据 2. 输出流，发送数据
	 * 
	 * @author china
	 *
	 */
	private class MyChannel implements Runnable {
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning = true;

		/**
		 * @param dis
		 * @param dos
		 * @throws IOException
		 */
		public MyChannel(Socket socket) {
			super();
			try {
				this.dis = new DataInputStream(socket.getInputStream());
				this.dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
//				e.printStackTrace();
				CloseUtil.closeAll(dis, dos);
				isRunning = false;
			}
		}

		/**
		 * 读取数据
		 * 
		 * @return
		 */
		private String receive() {
			String msg = "";
			try {
				msg = dis.readUTF();
			} catch (IOException e) {
				CloseUtil.closeAll(dis);
				isRunning = false;
				all.remove(this);
			}

			return msg;
		}

		/**
		 * 发送数据
		 */
		private void send(String msg) {
			if (null != msg && !msg.equals("")) {
				try {
					dos.writeUTF(msg);
					dos.flush(); // write之后 勿忘flush
				} catch (IOException e) {
					CloseUtil.closeAll(dos);
					isRunning = false;
					all.remove(this);
				}
			}
		}
		
		/**
		 * 发送给其它client
		 */
		private void sendToOthers() {
			String msg = receive();
			// 遍历容器
			for (MyChannel myChannel : all) {
				if (myChannel == this) {
					continue;
				}
				// send
				myChannel.send(msg);
				
				// 如何实现私聊呢？ 》》》给每个 client 加名称
			}
		}

		@Override
		public void run() {
			while (isRunning) {
//				send(receive()); // 发送回自身
				sendToOthers();
			}
		}
	}
}
