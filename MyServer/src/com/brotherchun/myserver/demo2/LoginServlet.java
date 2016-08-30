package com.brotherchun.myserver.demo2;

public class LoginServlet extends Servlet {

	@Override
	public void doGet(Request request,Response response) {
		String name=request.getValueFromArgs("uname");
		String pwd=request.getValueFromArgs("pwd");
		StringBuilder responseContent=new StringBuilder();
		responseContent.append("<html><head><title>µÇÂ¼Ò³Ãæ</title></head>");
		responseContent.append("<body>");
		if(name==null||name.trim().equals("")||pwd==null||pwd.trim().equals("")){
			responseContent.append("µÇÂ¼Ê§°Ü");
		}else{
			responseContent.append("µÇÂ¼³É¹¦"+"\r\n"+"ÄãºÃ"+name);
		}
		responseContent.append("</body></html>");
		response.setResponseContent(responseContent.toString());
	}

	@Override
	public void doPost(Request request,Response response) {

	}

}
