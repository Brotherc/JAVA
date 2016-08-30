package com.brotherchun.myserver.demo2;

import java.util.HashMap;
import java.util.Map;

public class ServletContext {
	
	private Map<String,String> mapping;
	private Map<String,Servlet> servlet;
	
	public ServletContext(){
		mapping=new HashMap<String,String>();
		servlet=new HashMap<String,Servlet>();
	}
	
	public Map<String, String> getMapping() {
		return mapping;
	}
	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	public Map<String, Servlet> getServlet() {
		return servlet;
	}
	public void setServlet(Map<String, Servlet> servlet) {
		this.servlet = servlet;
	}
	
	
}
