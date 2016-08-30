package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Snake {

	private Node head=null;
	private Node tail=null;
	private int size=0;
	private Yard y;
	
	Node n=new Node(20, 30, Dir.L);
	private class Node{
		int row,col;
		int w=Yard.BLOCK_SIZE,h=Yard.BLOCK_SIZE;
		Dir dir=Dir.L;
		Node next=null;
		Node prev=null;
		
		public Node(int row,int col,Dir dir){
			this.row=row;
			this.col=col;
			this.dir=dir;
		}
		
		public void draw(Graphics g){
			Color c=g.getColor();
			g.setColor(Color.BLACK);
			g.fillRect(col*Yard.BLOCK_SIZE, row*Yard.BLOCK_SIZE, w, h);
			
			g.setColor(c);
		}
	} 

	public Snake(Yard y){
		head=n;
		tail=n;
		size=1;
		this.y=y;
	}
	
	
	private Rectangle getRectangle(){
		return new Rectangle(head.col*Yard.BLOCK_SIZE, head.row*Yard.BLOCK_SIZE, head.w, head.h);
	}
	
	public void eat(Egg e){
		if(getRectangle().intersects(e.getRectangle())){
			e.reCome();
			this.addNode_Head();
			y.setScore(y.getScore()+5);
		}
	}
	
	public void addNode_Tail(){
		Node node=null;
		switch (tail.dir) {
		case L:
			node=new Node(tail.row, tail.col+1, tail.dir);
			break;
		case R:
			node=new Node(tail.row, tail.col-1, tail.dir);
			break;
		case U:
			node=new Node(tail.row+1, tail.col, tail.dir);
			break;
		case D:
			node=new Node(tail.row-1, tail.col, tail.dir);
			break;
		}
		
		tail.next=node;
		node.prev=tail;
		tail=node;
		size++;
	}
	
	public void addNode_Head(){
		Node node=null;
		switch (head.dir) {
		case L:
			node=new Node(head.row, head.col-1, head.dir);
			break;
		case R:
			node=new Node(head.row, head.col+1, head.dir);
			break;
		case U:
			node=new Node(head.row-1, head.col, head.dir);
			break;
		case D:
			node=new Node(head.row+1, head.col, head.dir);
			break;
		}
		
		node.next=head;
		head.prev=node;
		head=node;
		size++;
	}
	
	private void deleteNode_Tail() {
		if(size==0) return;
		tail=tail.prev;
//		tail.next.prev=null;
		tail.next=null;
		size--;
	}
	
	public void draw(Graphics g){
		
		if(size<=0)return ;
		else {
			for(Node n=head;n!=null;n=n.next){
				n.draw(g);
			}
		}
		move();
	}

	private void move() {
		addNode_Head();
		deleteNode_Tail();
		checkDeath();
	}


	private void checkDeath() {
		if(head.row<0||head.row>Yard.ROWS-4||head.col<0||head.col>Yard.COLS-2)
			y.stop();
		for(Node n=head.next;n!=null;n=n.next){
			if(n.col==head.col&&n.row==head.row)
				y.stop();
		}
	}


	public void keypressed(KeyEvent e) {
		int key=e.getKeyCode();
		switch(key){
		case KeyEvent.VK_LEFT:
			if(head.dir!=Dir.R)
			head.dir=Dir.L;
			break;
		case KeyEvent.VK_RIGHT:
			if(head.dir!=Dir.L)
			head.dir=Dir.R;
			break;
		case KeyEvent.VK_UP:
			if(head.dir!=Dir.D)
			head.dir=Dir.U;
			break;
		case KeyEvent.VK_DOWN:
			if(head.dir!=Dir.U)
			head.dir=Dir.D;
			break;
		}
	}
	
}
