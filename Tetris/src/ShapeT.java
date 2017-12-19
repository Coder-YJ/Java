
public class ShapeT extends Shape{

	boolean isAlive;		// 表示当前实例是否处于活动状态
	int shape;              // 用于表示当前实例形状的状态，取值 0-3,表示四种不同的形状
	Block[] shapeBlock;
	BlockPoint[] shapePositionPoint;
	BlockPoint[][] blockPoint;
	GamePanel gamePanel;
	public ShapeT(GamePanel gamePanel) {
		// TODO Auto-generated constructor stub
		super(gamePanel);
		
		// 设置形状的初始位置
		shapePositionPoint[0] = blockPoint[gamePanel.xPointCount / 2 - 1][1];
		shapePositionPoint[1] = blockPoint[gamePanel.xPointCount / 2 - 0][1];
		shapePositionPoint[2] = blockPoint[gamePanel.xPointCount / 2 + 1][1];
		shapePositionPoint[3] = blockPoint[gamePanel.xPointCount / 2 - 0][0];
		
		add();
	}

	// 变换形状，本类实例有四种可变形状，形状变换方向为顺时针方向
	// 形状初始状态为               口                数字顺序为                      3
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
					block[3] = blockPoint[x + 2][y + 0];
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
					block[3] = blockPoint[x + 0][y + 2];
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
					block[3] = blockPoint[x - 2][y + 0];
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
					block[3] = blockPoint[x + 0][y - 2];
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
}
