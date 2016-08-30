package com.brotherchun.myserver.demo1;

import java.io.IOException;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Request {

	private String method;
	private String uri;
	private String arg;
	private Map<String, List<String>> args;
	private Socket client;
	private String content;
	private static final String LINE = "\r\n";

	public Request(Socket client) {
		method = "";
		uri = "";
		arg = "";
		content = "";
		args = new HashMap<String, List<String>>();
		this.client=client;
	}

	public void request() throws IOException {
		int len;
		byte[] b = new byte[20480];
		len = client.getInputStream().read(b);
		content = new String(b, 0, len);
		System.out.println(content);
		parse();
		parseArgs();
	}

	public void parse() {
		String info = content.substring(0, content.indexOf(LINE));
		String[] ss = info.split(" ");
		method = ss[0];
		if (method.equalsIgnoreCase("get")) {
			if (ss[1].contains("\\?")) {
				uri = info.substring(info.indexOf("/"), info.indexOf("?"));
				arg = ss[1].substring(ss[1].indexOf("?"));
			} else {
				uri = ss[1];
			}
		} else {
			uri = ss[1];
			arg = content.substring(content.lastIndexOf(LINE)).trim();
		}
		System.out.println(method + " " + uri);
	}

	public void parseArgs() throws IOException {
		StringTokenizer token = new StringTokenizer(arg, "&");
		while (token.hasMoreTokens()) {
			String keyValue = token.nextToken();
			String[] split = keyValue.split("=");
			String key = split[0];
			String value = split[0];
			if (split.length == 2) {
				value =URLDecoder.decode( split[1], "gbk");
			}
			if (!args.containsKey(key)) {
				args.put(key, new ArrayList<String>());
				List<String> values = args.get(key);
				values.add(value);
			} else {
				List<String> values = args.get(key);
				values.add(value);
			}
		}
		Set<String> keys = args.keySet();
		for (String key : keys) {
			List<String> list = args.get(key);
			System.out.print(key);
			for (String value : list) {
				System.out.print(" " + value);
			}
			System.out.println();
		}
	}

	public String getValueFromArgs(String name) {
		if (!args.containsKey(name)) {
			return null;
		} else {
			return getValuesFromArgs(name)[0];
		}
	}
	
	public String[] getValuesFromArgs(String name) {
		if (!args.containsKey(name)) {
			return null;
		} else {
			List<String>list=args.get(name);
			return list.toArray(new String[0]);
		}
	}
}
