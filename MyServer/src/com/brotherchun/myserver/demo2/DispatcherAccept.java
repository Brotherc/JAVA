package com.brotherchun.myserver.demo2;

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

		System.out.println(request.getUri());
			Servlet servlet=new WebApp().getServlet(request.getUri());
			if(servlet==null){
				response.response(404);
			}else{
				servlet.server(request, response);
				response.response(200);
			}
	}

}
