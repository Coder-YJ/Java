
public class ShapeSeven extends Shape implements InterfaceShapeMotion{

	boolean isAlive;		// 表示当前实例是否处于活动状态
	int shape;              // 用于表示当前实例形状的状态，取值 0-3,表示四种不同的形状
	Block[] shapeBlock;
	BlockPoint[] shapePositionPoint;
	BlockPoint[][] blockPoint;
	GamePanel gamePanel;
	public ShapeSeven(GamePanel gamePanel) {
		// TODO Auto-generated constructor stub
		this.gamePanel = gamePanel;
		isAlive = true;
		shape = 0;
		blockPoint = gamePanel.blockPoint;
		shapeBlock = new Block[4];
		for (int i = 0; i < 4; i++) {
			shapeBlock[i] = new Block();
		}
		shapePositionPoint = new BlockPoint[4];
		
		// 设置形状的初始位置
		shapePositionPoint[0] = blockPoint[gamePanel.xPointCount / 2 - 1][1];
		shapePositionPoint[1] = blockPoint[gamePanel.xPointCount / 2 + 0][1];
		shapePositionPoint[2] = blockPoint[gamePanel.xPointCount / 2 + 1][1];
		shapePositionPoint[3] = blockPoint[gamePanel.xPointCount / 2 + 1][0];
		
		add();
	}

	// 变换形状，本类实例有四种可变形状，形状变换方向为顺时针方向
	// 形状初始状态为                    口                数字顺序为                      3
	//                  口口口                                                     0 1 2
	@Override
	public void changeShape() {
		// TODO Auto-generated method stub
		boolean isChange = false;
		BlockPoint[] block = new BlockPoint[4];
		int x, y;
		x = shapePositionPoint[0].getNumberX();
		y = shapePositionPoint[0].getNumberY();
		switch (shape) {
		
			case 0:
			{   // 由向上形状变换为向右形状
				if(y + 1 < gamePanel.yPointCount && y - 1 >=0
					&& x + 2 < gamePanel.xPointCount) {   // 判断形状变换后是否超出游戏区域边界
					
					block[0] = blockPoint[x + 1][y - 1];
					block[1] = blockPoint[x + 1][y + 0];
					block[2] = blockPoint[x + 1][y + 1];
					block[3] = blockPoint[x + 2][y + 1];
				} else {
					break;
				}
				
				for (int i = 0; i < 4; i++) {
					if (block[i].isHaveBlock == true) {   // 先判断变化后的形状是否和游戏区域中已有方块冲突
						break;
					}
					
					if(i == 3)
					{
						isChange = true;
					}
				}
				
				if (isChange == true) {
					for (int i =0; i < 4; i++){
						shapePositionPoint[i] = block[i];
					}
					shape = 1;
				}
				break;
			}
				
			case 1:
			{   // 由向右形状变换为向下形状
				if ((x - 1 >= 0 ) && (x + 1 < gamePanel.xPointCount)
					 && y + 2 < gamePanel.yPointCount) {
					block[0] = blockPoint[x + 1][y + 1];
					block[1] = blockPoint[x + 0][y + 1];
					block[2] = blockPoint[x - 1][y + 1];
					block[3] = blockPoint[x - 1][y + 2];
				} else {
					break;
				}

				
				for (int i = 0; i < 4; i++) {
					if (block[i].isHaveBlock == true) {   // 先判断变化后的形状是否和游戏区域中已有方块冲突
						break;
					}
					
					if(i == 3)
					{
						isChange = true;
					}
				}
				
				if (isChange == true) {
					for (int i =0; i < 4; i++){
						shapePositionPoint[i] = block[i];
					}
					shape = 2;
				}
				break;
			}
			
			case 2:
			{
				   // 由向下形状变换为向左形状
				if ((x - 2 >= 0 ) && (y + 1 < gamePanel.yPointCount)
					  && y - 1 >= 0) {
					block[0] = blockPoint[x - 1][y + 1];
					block[1] = blockPoint[x - 1][y + 0];
					block[2] = blockPoint[x - 1][y - 1];
					block[3] = blockPoint[x - 2][y - 1];
				} else {
					break;
				}

				
				for (int i = 0; i < 4; i++) {
					if (block[i].isHaveBlock == true) {   // 先判断变化后的形状是否和游戏区域中已有方块冲突
						break;
					}
					
					if(i == 3)
					{
						isChange = true;
					}
				}
				
				if (isChange == true) {
					for (int i =0; i < 4; i++){
						shapePositionPoint[i] = block[i];
					}
					shape = 3;
				}
				break;
			
			}
			
			case 3:
			{

				   // 由向左形状变换为向上形状
				if ((x - 1 >= 0 ) && (x + 1 < gamePanel.xPointCount)
					  && y - 2 >=0) {
					block[0] = blockPoint[x - 1][y - 1];
					block[1] = blockPoint[x + 0][y - 1];
					block[2] = blockPoint[x + 1][y - 1];
					block[3] = blockPoint[x + 1][y - 2];
				} else {
					break;
				}

				
				for (int i = 0; i < 4; i++) {
					if (block[i].isHaveBlock == true) {   // 先判断变化后的形状是否和游戏区域中已有方块冲突
						break;
					}
					
					if(i == 3)
					{
						isChange = true;
					}
				}
				
				if (isChange == true) {
					for (int i =0; i < 4; i++){
						shapePositionPoint[i] = block[i];
					}
					shape = 0;
				}
				break;
			
			
			}
			
			default:
		}
		
		if (isChange == true) {   // 如果形状发生改变，则更新形状
			updateShape();
		}
		
	}

	// 向左移动
	@Override
	public void goLeft() {
		// TODO Auto-generated method stub
		boolean isMove = false;
		int x, y;
		for (int i = 0; i < 4; i++) {
			
			x = shapePositionPoint[i].getNumberX() - 1;
			y = shapePositionPoint[i].getNumberY();
			
			if (x < 0) {  // 判断左移一步后是否移出边界
				break;
			} else if (blockPoint[x][y].isHaveBlock == true) { // 判断左边位置点是否已经存在方块
				break;
			}
			
			if(i == 3) {
				isMove = true;
			}
		}
		
		if (isMove == true) {
			for (int i = 0; i < 4; i++) {
				x = shapePositionPoint[i].getNumberX() - 1;
				y = shapePositionPoint[i].getNumberY();
				shapePositionPoint[i] = blockPoint[x][y];
			}
			
			updateShape();
		}
	}

	@Override
	public void goRight() {
		// TODO Auto-generated method stub
		boolean isMove = false;
		int x, y;
		for (int i = 0; i < 4; i++) {
			
			x = shapePositionPoint[i].getNumberX() + 1;
			y = shapePositionPoint[i].getNumberY();
			if (x >= gamePanel.xPointCount) {
				break;
			} else if (blockPoint[x][y].isHaveBlock== true) {
				break;
			}
			
			if(i == 3) {
				isMove = true;
			}
		} 
		
		if (isMove == true) {
			for (int i = 0; i < 4; i++) {
				x = shapePositionPoint[i].getNumberX() + 1;
				y = shapePositionPoint[i].getNumberY();
				shapePositionPoint[i] = blockPoint[x][y];
			}
			
			updateShape();
		}
	}

	@Override
	public void goDown() {
		// TODO Auto-generated method stub
		boolean isMove = false;
		int x, y;
		for (int i = 0; i < 4; i++) {
			
			x = shapePositionPoint[i].getNumberX();
			y = shapePositionPoint[i].getNumberY() + 1;
			if (y >= gamePanel.yPointCount) {
				isAlive = false;           // 若已经到达底部，则本方块被固定
				break;
			} else if (blockPoint[x][y].isHaveBlock == true) {
				isAlive = false;           // 若下一个位置已经存在方块，则本方块被固定
				break;
			} 
			
			if(i == 3) {
				isMove = true;
			}
		} 
		
		if (isMove == true) {
			for (int i = 0; i < 4; i++) {
				x = shapePositionPoint[i].getNumberX();
				y = shapePositionPoint[i].getNumberY() + 1;
				shapePositionPoint[i] = blockPoint[x][y];
			}
			
			updateShape();
		}
		
		if(isAlive == false)
		{
			for(int i= 0; i < 4; i++) {
				x = shapePositionPoint[i].getNumberX();
				y = shapePositionPoint[i].getNumberY();
				blockPoint[x][y].setHaveBlock(true);;
			}
		}
	}
	
	
	
	public void add() {
		
		gamePanel.add(shapeBlock[0]);
		gamePanel.add(shapeBlock[1]);
		gamePanel.add(shapeBlock[2]);
		gamePanel.add(shapeBlock[3]);
		updateShape();
	}

	@Override
	public void goDownFast() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateShape() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i <4; i++) {
			shapeBlock[i].setLocation(shapePositionPoint[i].positionX ,
					                  shapePositionPoint[i].positionY);
		}
	}

}
