package com.brotherchun.myserver.demo1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author brotherchun
 *
 *服务器 响应GET或POST请求
 */

public class MyServer2 {
	private ServerSocket socket = null;

	public static void main(String[] args) {
		MyServer2 myServer = new MyServer2();
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
		BufferedInputStream br = null;
		try {
			Socket client = socket.accept();
			br = new BufferedInputStream(client.getInputStream());
			int len;
			byte[] b=new byte[1024];
			StringBuilder sb=new StringBuilder();
			while ((len = br.read(b)) != -1) {
				String s=new String(b, 0, len);
				sb.append(s);
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (Exception e) {
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
