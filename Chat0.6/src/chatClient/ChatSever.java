package chatClient;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatSever {
	
	private List<Client> clients=new ArrayList<Client>();
	
	private class Client implements  Runnable {
		
		private Socket s;
		private BufferedReader br;
		private PrintWriter pw;
		
		public Client(Socket s){
			this.s=s;
			try {
				br=new BufferedReader(new InputStreamReader(s.getInputStream()));
				pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void send(String s){
			pw.println(s);
		}
		
		public void run() {
			String line=null;
			try {
				while((line=br.readLine())!=null){
System.out.println(line);
					for(Client c:clients){
						if(c!=this)
						c.send(line);
					}
				}
			} catch (Exception e) {
				System.out.println("A Client Close");
			}finally{
				try {
					if(pw!=null)pw.close();
					if(br!=null)br.close();
					if(s!=null)s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ChatSever().start();
	}
	
	public void start(){
		ServerSocket ss=null;
		Socket s=null;
		
		try {
			ss=new ServerSocket(8888);
			while(true){
				s=ss.accept();
System.out.println("Accept a Client");
				Client c=new Client(s);
				clients.add(c);
				new Thread(c).start();
			}
		} catch(IOException e){
			System.out.println("A Client Close");
		}
	}

}


