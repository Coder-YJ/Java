public class ShapePillar extends Shape {

	public ShapePillar(GamePanel gamePanel) {
		// TODO Auto-generated constructor stub
		super(gamePanel);
		
		// 设置形状的初始位置
		shapePositionPoint[0] = blockPoint[gamePanel.xPointCount / 2 - 1][0];
		shapePositionPoint[1] = blockPoint[gamePanel.xPointCount / 2 - 1][1];
		shapePositionPoint[2] = blockPoint[gamePanel.xPointCount / 2 - 1][2];
		shapePositionPoint[3] = blockPoint[gamePanel.xPointCount / 2 - 1][3];
		
		add();
	}

	// 变换形状，本类实例只有两种形状可变
	// 形状初始状态为              口口口口                数字顺序为                     0 1 2 3
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
			{  
				   // 由竖直形状变换为水平形状
				if ((x - 1 >= 0 ) && (x + 2 < gamePanel.xPointCount)) {
					block[0] = blockPoint[x - 1][y];
					block[1] = blockPoint[x][y];
					block[2] = blockPoint[x + 1][y];
					block[3] = blockPoint[x + 2][y];
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
			{
				 // 由水平形状变换为竖直形状
				if(y + 3 < gamePanel.yPointCount && x + 1 < gamePanel.xPointCount) {   // 判断形状变换后是否超出游戏区域边界
					
					block[0] = blockPoint[x + 1][y];
					block[1] = blockPoint[x + 1][y + 1];
					block[2] = blockPoint[x + 1][y + 2];
					block[3] = blockPoint[x + 1][y + 3];
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
