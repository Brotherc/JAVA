package com.brotherchun.myserver.demo2;

public class RegisterServlet extends Servlet {

	@Override
	public void doGet(Request request, Response response) {
		StringBuilder responseContent=new StringBuilder();
		responseContent.append("<html><head><title>ע��ҳ��</title></head>");
		responseContent.append("<body>ע��</body></html>");
		response.setResponseContent(responseContent.toString());
	}

	@Override
	public void doPost(Request request, Response response) {

	}

}
