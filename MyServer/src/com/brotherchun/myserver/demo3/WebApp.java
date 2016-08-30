package com.brotherchun.myserver.demo3;

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
		Map<String,String> servlet=context.getServlet();
		servlet.put("login", "com.brotherchun.myserver.demo3.LoginServlet");
		servlet.put("register", "com.brotherchun.myserver.demo3.RegisterServlet");
	}
	
	public Servlet getServlet(String uri) throws ReflectiveOperationException{
		String name=context.getServlet().get(context.getMapping().get(uri));
			return (Servlet) Class.forName(name).newInstance();

	}
}
