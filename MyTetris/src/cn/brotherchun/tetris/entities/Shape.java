package cn.brotherchun.tetris.entities;

import java.awt.Color;
import java.awt.Graphics;

import cn.brotherchun.tetris.listener.ShapeListener;
import cn.brotherchun.tetris.utils.Utils;

public class Shape {

	public  static final int LEFT=0;
	public  static final int RIGHT=1;
	public  static final int DOWN=2;
	public  static final int ROTATE=3;
	private int[][]body;
	private int status;
	private int left=9;
	private int top=0;
	
	private ShapeListener l;
	
	public void moveLeft(){
		System.out.println("Shape's moveLeft");
		left--;
	}
	
	public void moveRight(){
		System.out.println("Shape's moveRight");
		left++;
	}
	
	public void moveDown(){
		System.out.println("Shape's moveDown");
		top++;
	}
	
	public void rotate(){
		System.out.println("Shape's rotate");
		status=(status+1)%body.length;
	}
	
	public void drawMe(Graphics g){
		System.out.println("Shape's drawMe");
		g.setColor(Color.WHITE);
		for(int x=0;x<4;x++){
			for(int y=0;y<4;y++){
				if(isCheck(x, y)){
					g.drawRect((left+x)*Utils.SIZE, (top+y)*Utils.SIZE,Utils.SIZE, Utils.SIZE);
				}
			}
		}
	}
	private boolean isCheck(int x,int y){
		return body[status][y*4+x]==1;
	}
	public boolean isCheck(int x,int y,int action){
		int tmpstatus=status;
		if(action==ROTATE){
			tmpstatus=(tmpstatus+1)%body.length;
		}
		return body[tmpstatus][y*4+x]==1;
	}
	
	private class ShapeDriver implements Runnable{

		@Override
		public void run() {
			while(	l.isMoveDownable(Shape.this)){
				moveDown();

				l.shapeMoveDown(Shape.this);
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public Shape(){
		new Thread(new ShapeDriver()).start();
	}
	
	public void addListener(ShapeListener l){
		this.l=l;
	}
	public void setBody(int [][]body){
		this.body=body;
	}
	public void setStatus(int status){
		this.status=status;
	}
	public int getLeft(){
		return left;
	}
	public int getTop(){
		return top;
	}
}
