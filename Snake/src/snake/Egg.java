package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Egg {
	
	private int col,row;
	private int w=Yard.BLOCK_SIZE,h=Yard.BLOCK_SIZE;
	private Color color=Color.ORANGE;
	private static Random r=new Random();
	
	public Egg(int col,int row){
		this.col=col;
		this.row=row;
	}
	
	public Egg(){
		this(r.nextInt(Yard.COLS-2),r.nextInt(Yard.ROWS-4));
	}
	
	public void draw(Graphics g){
		Color c=g.getColor();
		
		g.setColor(color);
		g.fillOval(col*Yard.BLOCK_SIZE, row*Yard.BLOCK_SIZE, w, h);
		g.setColor(c);
		if(color==Color.ORANGE)color=Color.YELLOW;
		else color=Color.ORANGE;
	}
	
	public void reCome(){
		this.col=r.nextInt(Yard.COLS-2);
		this.row=r.nextInt(Yard.ROWS-4);
	}
	
	public int getRow(){
		return this.row;
	}
	public int getCol(){
		return this.col;
	}
	public Rectangle getRectangle(){
		return new Rectangle(col*Yard.BLOCK_SIZE, row*Yard.BLOCK_SIZE, w, h);
	}
}
