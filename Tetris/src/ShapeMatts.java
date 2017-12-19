import java.awt.Container;

public class ShapeMatts extends Shape{


	public ShapeMatts(GamePanel gamePanel) {
		
		super(gamePanel);   // 调用父类构造函数
		
		// 设置形状的初始位置
		shapePositionPoint[0] = blockPoint[gamePanel.xPointCount / 2 - 1][0];
		shapePositionPoint[1] = blockPoint[gamePanel.xPointCount / 2][0];
		shapePositionPoint[2] = blockPoint[gamePanel.xPointCount / 2 - 1][1];
		shapePositionPoint[3] = blockPoint[gamePanel.xPointCount / 2][1];
		add();
	}

	// 变换形状，本类实例只一种形状，无需变换
	// 形状初始状态为                口口                数字顺序为                     0 1 
	//                    口口                                                              2 3
	@Override
	public void changeShape() {
		// TODO Auto-generated method stub
		
	}
}
