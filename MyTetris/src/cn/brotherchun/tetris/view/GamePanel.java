package cn.brotherchun.tetris.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import cn.brotherchun.tetris.entities.Ground;
import cn.brotherchun.tetris.entities.Shape;
import cn.brotherchun.tetris.utils.Utils;

public class GamePanel extends JPanel {

	private Shape shape;
	private Ground ground;
	private boolean isOver=false;
	private int score=0;
	
	public GamePanel(){
		setSize(Utils.SIZE*Utils.WIDTH,Utils.SIZE*Utils.HIGHT);
	}
	
	public void display(Shape shape,Ground ground){
		System.out.println("GamePanel's display");
		this.ground=ground;
		this.shape=shape;
		this.repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Utils.SIZE*Utils.WIDTH,Utils.SIZE*Utils.HIGHT);
		if(shape!=null&&ground!=null){
			shape.drawMe(g);
			ground.drawMe(g);
			g.setColor(Color.YELLOW);
			g.drawString("Score : "+score, 2*Utils.SIZE, 2*Utils.SIZE);
		}
		if(isOver){
			g.setColor(Color.RED);
			g.setFont(new Font("Consolas", Font.BOLD, 50));
			g.drawString("Game Over ", (Utils.WIDTH/5)*Utils.SIZE, (Utils.HIGHT/2)*Utils.SIZE);
		}
	}
	public void setOver(boolean isOver){
		this.isOver=isOver;
	}
	public void setScore(int score){
		this.score+=score;
	}
}
