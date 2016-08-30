package com.brotherchun.myserver.demo3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author brotherchun
 *
 *         服务器 响应GET或POST请求
 */

public class MyServer {
	private ServerSocket socket = null;
	private boolean isShutDown = false;

	public static void main(String[] args) {
		MyServer myServer = new MyServer();
		myServer.start();
	}

	public void start() {
		try {
			socket = new ServerSocket(8888);
			this.receiver();
		} catch (IOException e) {
			e.printStackTrace();
			isShutDown = true;
			this.stop();
		}
	}

	public void receiver() {
		Socket client = null;
		try {
			while(!isShutDown){
				new Thread(new DispatcherAccept(socket.accept())).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
			isShutDown=true;
		} finally {
			try {
				if (client != null)
					client.close();
				if(isShutDown)
					this.stop();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void stop() {
		try {
			if (socket != null)
				socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
