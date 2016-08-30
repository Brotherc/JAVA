package chatClient;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;

public class ChatFrame extends JFrame{
	
	protected class Client implements Runnable{
		@Override
		public void run() {
			String line=null;
			try {
				while((line=br.readLine())!=null){
System.out.println(line);
				ta.append(line+'\n');
				}
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(br!=null){
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private TextArea ta=new TextArea();
	private TextField tf=new TextField();
	private Socket s=null;
	private PrintWriter pw=null;
	private BufferedReader br=null;
	
	public ChatFrame(){
		super("chat");
		init();
		connect();
		new Thread(new Client()).start();
	}

	
	public void init(){
		setBounds(200, 100, 800, 600);
		add(ta,BorderLayout.NORTH);
		add(tf,BorderLayout.SOUTH);
		pack();
		tf.addActionListener(new TFListener());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class TFListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String str=tf.getText();
			ta.append(str+'\n');
			tf.setText("");
			pw.println(str);
		}
		
	}
	
	public void connect(){
		
			try {
				s=new Socket(InetAddress.getLocalHost(), 8888);
				pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())),true);
				br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
System.out.println("connect");
			

	}
	
}
