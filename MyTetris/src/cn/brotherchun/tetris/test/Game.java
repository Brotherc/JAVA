package cn.brotherchun.tetris.test;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.brotherchun.tetris.controller.Controller;
import cn.brotherchun.tetris.entities.Ground;
import cn.brotherchun.tetris.entities.ShapeFactory;
import cn.brotherchun.tetris.utils.Utils;
import cn.brotherchun.tetris.view.GamePanel;

public class Game {

	public static void main(String[] args) {
		GamePanel panel=new GamePanel();
		ShapeFactory factory=new ShapeFactory();
		Ground ground=new Ground();
		Controller controller=new Controller( factory, ground, panel);
		panel.addKeyListener(controller);
		JFrame frame=new JFrame("¶íÂÞË¹·½¿é");
		frame.addKeyListener(controller);
		init(frame,panel);

		controller.newGame();
	}

	public static void init(JFrame frame,JPanel panel){
		Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((screenSize.width-Utils.WIDTH*Utils.SIZE)/2,(screenSize.height-Utils.HIGHT*Utils.SIZE)/2, Utils.WIDTH*Utils.SIZE,Utils.HIGHT*Utils.SIZE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(panel);
		frame.setVisible(true);
	}
}
