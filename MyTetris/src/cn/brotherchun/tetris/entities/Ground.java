package cn.brotherchun.tetris.entities;

import java.awt.Graphics;

import cn.brotherchun.tetris.utils.Utils;

public class Ground {

	private int[][] obstacles=new int[Utils.WIDTH][Utils.HIGHT];
	
	public int accept(Shape shape){
		System.out.println("Ground's accept");
		int top=shape.getTop();
		int left=shape.getLeft();
		for(int x=0;x<4;x++){
			for(int y=0;y<4;y++){
				if(shape.isCheck(x, y, -1)){
					obstacles[left+x][top+y]=1;
				}
			}
		}
		int line=deleteFullLine();
		return line;
	}
	public int deleteFullLine(){
		int line=0;
		for(int y=Utils.HIGHT-3;y>=0;y--){
			boolean full=true;
			for(int x=0;x<Utils.WIDTH-1;x++){
					if(obstacles[x][y]==0)
						full=false;
			}
			if(full){
				deleteLine(y);y++;
				line++;
			}
				
		}
		return line;
	}
	
	private void deleteLine(int lineNumber) {
		for(int y=lineNumber;y>0;y--){
			for(int x=0;x<Utils.WIDTH;x++){
				obstacles[x][y]=obstacles[x][y-1];
			}
		}
		for(int x=0;x<Utils.WIDTH;x++){
			obstacles[x][0]=0;
		}
		System.out.println("Ground's delete");
	}
	
	public boolean isFull(){
		for(int x=0;x<Utils.WIDTH;x++){
			if(obstacles[x][0]==1){
				return true;
			}
		}
		return false;
	}
	public void drawMe(Graphics g){
		System.out.println("Ground's drawMe");
		for(int x=0;x<Utils.WIDTH;x++){
			for(int y=0;y<Utils.HIGHT;y++){
				if(obstacles[x][y]==1){
					g.draw3DRect(x*Utils.SIZE, y*Utils.SIZE, Utils.SIZE, Utils.SIZE, true);
				}
			}
		}
	}
	
	public boolean isMove(Shape shape,int action){
		int left=shape.getLeft();
		int top=shape.getTop();
		switch (action) {
		case 0:
			left--;
			break;
		case 1:
			left++;
			break;
		case 2:
			top++;
			break;

		default:
			break;
		}

		for(int x=0;x<4;x++){
			for(int y=0;y<4;y++){
				if(shape.isCheck(x, y, action)){
					if(left+x>=Utils.WIDTH-1||left+x<=-1||top+y>=Utils.HIGHT-2||obstacles[left+x][top+y]==1) return false;
				}
			}
		}
		return true;
	}
}
