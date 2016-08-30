package com.brotherchun.myserver.demo2;

import java.util.Map;

public class WebApp {
	private static ServletContext context;
	static{
		context=new ServletContext();
		Map<String,String> mapping=context.getMapping();
		mapping.put("/log", "login");
		mapping.put("/login", "login");
		mapping.put("/reg", "register");
		mapping.put("/register", "register");
		Map<String,Servlet> servlet=context.getServlet();
		servlet.put("login", new LoginServlet());
		servlet.put("register", new RegisterServlet());
	}
	
	public Servlet getServlet(String uri){
		return context.getServlet().get(context.getMapping().get(uri));
	}
}
