package cn.brotherchun.tetris.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import cn.brotherchun.tetris.entities.Ground;
import cn.brotherchun.tetris.entities.Shape;
import cn.brotherchun.tetris.entities.ShapeFactory;
import cn.brotherchun.tetris.listener.ShapeListener;
import cn.brotherchun.tetris.view.GamePanel;

public class Controller extends KeyAdapter implements ShapeListener {

	private  Shape shape;
	private  ShapeFactory factory;
	private  Ground ground;
	private  GamePanel panel;

	public Controller(ShapeFactory factory,Ground ground,GamePanel panel) {
		this.factory=factory;
		this.ground=ground;
		this.panel=panel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			if(isMoveDownable(shape))
			shape.moveDown();
			break;
		case KeyEvent.VK_RIGHT:
			if(ground.isMove(shape, shape.RIGHT))
			shape.moveRight();
			break;
		case KeyEvent.VK_LEFT:
			if(ground.isMove(shape, shape.LEFT))
			shape.moveLeft();
			break;
		case KeyEvent.VK_UP:
			if(ground.isMove(shape, shape.ROTATE))
			shape.rotate();
		default:
			break;
		}
		panel.display(shape, ground);
	}

	@Override
	public void shapeMoveDown(Shape shape) {
		panel.display(shape, ground);
	}

	public void newGame() {
		shape = factory.getShape(this);
	}

	@Override
	public synchronized boolean isMoveDownable(Shape shape) {
		if(this.shape!=shape)return false;
		boolean result=ground.isMove(shape, shape.DOWN);
		if(!result){
			int line=ground.accept(shape);
			panel.setScore(line*5);
			if(!ground.isFull()){
				this.shape=factory.getShape(this);
			}else{
				panel.setOver(true);
				panel.display(shape, ground);
			}

		}
		return result;
	}
}
