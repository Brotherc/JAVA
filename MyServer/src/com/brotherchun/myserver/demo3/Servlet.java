package com.brotherchun.myserver.demo3;

public abstract class Servlet {
	
	public void server(Request request,Response response){
		this.doGet(request,response);
		this.doPost(request,response);
	}
	public abstract void doGet(Request request,Response response);
	public abstract void doPost(Request request,Response response);
}
