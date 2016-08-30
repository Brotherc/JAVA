package com.brotherchun.myserver.demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author brotherchun
 * 
 *服务器 响应GET请求
 */
public class MyServer {
	private ServerSocket socket = null;

	public static void main(String[] args) {
		MyServer myServer = new MyServer();
		myServer.start();
		myServer.stop();
	}

	public void start() {
		try {
			socket = new ServerSocket(8888);
			this.receiver();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void receiver() {
		BufferedReader br = null;
		try {
			Socket client = socket.accept();
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()).length()>0) {
				sb.append(line + "\r\n");
				if(line==null)
					break;
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
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
