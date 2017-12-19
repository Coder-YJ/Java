import java.awt.Container;

public class ShapeMatts implements InterfaceShapeMotion{

	boolean isAlive;		// 表示当前实例是否处于乎哟东状态
	int shape;              // 用于表示当前实例形状的状态，取值 0-3,表示四种不同的形状
	Block[] shapeBlock;
	BlockPoint[] shapePositionPoint;
	BlockPoint[][] blockPoint;
	GamePanel gamePanel;
	public ShapeMatts(GamePanel gamePanel) {
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
		shapePositionPoint[0] = blockPoint[gamePanel.xPointCount / 2 - 1][0];
		shapePositionPoint[1] = blockPoint[gamePanel.xPointCount / 2][0];
		shapePositionPoint[2] = blockPoint[gamePanel.xPointCount / 2 - 1][1];
		shapePositionPoint[3] = blockPoint[gamePanel.xPointCount / 2][1];
		
		add();
	}

	@Override
	public void changeShape(int shape) {
		// TODO Auto-generated method stub
		
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
