package com.brotherchun.myserver.demo3;

import java.util.HashMap;
import java.util.Map;

public class ServletContext {
	
	private Map<String,String> mapping;
	private Map<String,String> servlet;
	
	public ServletContext(){
		mapping=new HashMap<String,String>();
		servlet=new HashMap<String,String>();
	}
	
	public Map<String, String> getMapping() {
		return mapping;
	}
	public void setMapping(Map<String, String> mapping) {
		this.mapping = mapping;
	}
	public Map<String, String> getServlet() {
		return servlet;
	}
	public void setServlet(Map<String, String> servlet) {
		this.servlet = servlet;
	}
	
	
}
