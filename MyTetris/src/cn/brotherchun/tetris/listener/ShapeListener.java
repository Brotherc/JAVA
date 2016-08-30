package cn.brotherchun.tetris.listener;

import cn.brotherchun.tetris.entities.Shape;

public interface ShapeListener {
	void shapeMoveDown(Shape shape);
	boolean isMoveDownable(Shape shape);
}
