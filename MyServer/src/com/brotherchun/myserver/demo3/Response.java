package com.brotherchun.myserver.demo3;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
	
	private static final String LINE="\r\n";
	private static final String BLANK=" ";
	private String responseContent;
	private int code;
	private Socket s;
	
	public Response(Socket s){
		this.s=s;
		responseContent="";
	}
	public void setResponseContent(String responseContent){
		this.responseContent=responseContent;
	}
	public void response(int code){
		this.code=code;

		PrintWriter pw=null;
		try {
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String response=getResponseInfo().toString()+getResponseHead().toString()+LINE+responseContent;
		System.out.println(response);
		pw.println(response);
	}
	
	private StringBuilder getResponseInfo(){
		StringBuilder info=new StringBuilder();
		info.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
		switch(code){
		case 200:
			info.append("OK").append(LINE);
			break;
		case 404:
			info.append("NOT FOUND").append(LINE);
			break;
		case 500:
			info.append("SEVER ERROR").append(LINE);
			break;
		}
		return info;
	}
	private StringBuilder getResponseHead(){
		StringBuilder head=new StringBuilder();
		head.append("Server:brotherchun Server/0.0.1").append(LINE);
		head.append("Date:").append(new Date()).append(LINE);
		head.append("Content-type:text/html;charset=GBK").append(LINE);
		head.append("Content-Length:").append(responseContent.length()).append(LINE);
		
		return head;
	}
}
