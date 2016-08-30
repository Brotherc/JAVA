package com.brotherchun.myserver.demo1;

import java.io.IOException;
import java.net.Socket;

public class DispatcherAccept implements Runnable{

	private Socket client;
	
	public DispatcherAccept(Socket client){
		this.client=client;
	}
	
	@Override
	public void run() {
		Request request = new Request(client);
		Response response = new Response(client);
		try {
			Servlet.server(200, request, response);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
