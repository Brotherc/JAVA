package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Yard extends JFrame{
	
	public static final int ROWS=35;
	public static final int COLS=35;
	public static final int BLOCK_SIZE=15;
	private int score=0;
	private boolean flag=true;
	private Snake snake=new Snake(this);
	private Egg egg=new Egg();
	
	public Yard(String s){
		super(s);
		init();
	}
	public void setScore(int score){
		this.score=score;
	}
	public int  getScore(){
		return this.score;
	}
	
	public void init(){
	    Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width-COLS*BLOCK_SIZE)/2,(screenSize.height-ROWS*BLOCK_SIZE)/2, COLS*BLOCK_SIZE, ROWS*BLOCK_SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		addKeyListener(new MyKey());
		this.setContentPane(new P());
		new Thread(new paintThread()).start();
		
	}

	private class paintThread implements Runnable{
		@Override
		public void run() {
			while(flag){
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		}	
	}
	private class P extends JPanel{

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Color c=g.getColor();
			
			g.setColor(Color.GRAY);
			g.fillRect(0, 0, COLS*BLOCK_SIZE, ROWS*BLOCK_SIZE);
			
			g.setColor(Color.DARK_GRAY);
			for(int i=1;i<ROWS;i++){
				g.drawLine(0, i*BLOCK_SIZE, COLS*BLOCK_SIZE,  i*BLOCK_SIZE);
			}
			for(int i=1;i<COLS;i++){
				g.drawLine( i*BLOCK_SIZE, 0, i*BLOCK_SIZE,  ROWS*BLOCK_SIZE);
			}

			snake.eat(egg);
			snake.draw(g);
			egg.draw(g);
			
			g.setColor(Color.WHITE);
			g.drawString("Score : "+score, 2*BLOCK_SIZE, 2*BLOCK_SIZE);
			
			if(flag==false){
				g.setColor(Color.RED);
				g.setFont(new Font("Consolas", Font.BOLD, 50));
				g.drawString("Game Over ", (COLS/3)*BLOCK_SIZE, (ROWS/2)*BLOCK_SIZE);
			}
				
			
			g.setColor(c);
		}
		
	}
	
	class MyKey extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			snake.keypressed(e);
		}
		
	}

	public void stop() {
		flag=false;
	}
}
