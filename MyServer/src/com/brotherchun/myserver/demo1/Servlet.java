package com.brotherchun.myserver.demo1;

import java.io.IOException;

public class Servlet {
	
	public static void server(int code,Request request,Response response) throws IOException{
		request.request();	
		String name=request.getValueFromArgs("uname");
		StringBuilder responseContent=new StringBuilder();
		responseContent.append("<html><head><title>HTTP��Ӧʾ��</title></head>");
		responseContent.append("<body>���"+name+"</body></html>");
		response.response(code, responseContent.toString());
	}
	
}
