import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.*;

/**
 *  俄罗斯方块游戏区域
 * @author QYJ
 *
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener{

	int blockSize = 20;               // 方块尺寸
	int xPointCount, yPointCount;     // x , y 方向上的方块个数
	BlockPoint[][] blockPoint;        // 将游戏区域分成 xPointCount*yPointCount个区域用于放置方块，每个区域用一个BlockPoint点表示
	Timer timer;
	Random random;
	int[] blocksOnLine;       		 // 表示某一行上有多少个方块
	int  continusLineCount;          // 表示出现了多少个连续行
	int  socre;                      // 游戏分数
	ArrayList<Shape> shapeList;      // 用于存储 形状对象
	int index = 0;                   // shapeList的指针
	boolean isGameOver;
	
	
	public GamePanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		xPointCount = 20;
		yPointCount = 30;
		blocksOnLine = new int[yPointCount];
		continusLineCount = 0;
		socre = 0;
		isGameOver = false;
		
		// 设置游戏区域的位置及大小
		setBounds(10, 10, xPointCount * blockSize, yPointCount * blockSize);
		setBackground(new Color(100, 220, 200));
		
		// 创建游戏所需的定时器及随机数
		timer = new Timer(700, this);
		timer.setInitialDelay(500);
		timer.start();
		random = new Random();
		random.setSeed(System.currentTimeMillis());
		
		// 生成位置点
		createBlockPoint();
		
		addKeyListener(this);
		validate();
		
	    // 需要设置可获取输入焦点，否则键盘事件无法响应;
		setFocusable(true);       
		
		shapeList = new ArrayList<Shape>();
		shapeList.add(new ShapeRightSeven(this));
	}

	private void createBlockPoint() {
		
		blockPoint = new BlockPoint[xPointCount][yPointCount];
		for	(int i = 0; i < xPointCount; i++) {
			for (int j = 0; j < yPointCount; j++) {
				
				blockPoint[i][j] = new BlockPoint();
				blockPoint[i][j].setPosition(i * 20, j * 20);
				blockPoint[i][j].setNumberX(i);
				blockPoint[i][j].setNumberY(j);
			}
		}
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if((shapeList.get(index)) != null && (shapeList.get(index)).isAlive == true) {
				(shapeList.get(index)).goLeft();
			}
		}
		
		// 
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if((shapeList.get(index)) != null && (shapeList.get(index)).isAlive == true) {
				(shapeList.get(index)).goRight();
			}
		}
		
		// 向下键：使形状向下移动，若长按则是快速向下移动
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if((shapeList.get(index)) != null && (shapeList.get(index)).isAlive == true) {
				(shapeList.get(index)).goDown();
				
				if((shapeList.get(index)).isAlive == false) {  //向下移动后若当前形状方块失效固定，则对所有方块进行处理，若有连成行的方块，则清除改行，同时计算分数，移动剩余方块
					clearBlocks();
				}
			}
		}
		
		// 向上键：改变形状方块的形状
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if((shapeList.get(index)) != null && (shapeList.get(index)).isAlive == true) {
				(shapeList.get(index)).changeShape();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		// 定时移动形状方块，若当前形状方块已失效，则生成新的形状方块;
		if (e.getSource() == timer) {
			
			if((shapeList.get(index)).isAlive){
				
				(shapeList.get(index)).goDown();
				
			} else {
				
			    int whichKindShapw = random.nextInt(7);
			    
			    switch (whichKindShapw) {
				    case 0:
				    { 
				    	shapeList.add(new ShapeMatts(this));
				    	index ++;
				    	break;
				    }
				    case 1:
				    { 
				    	shapeList.add(new ShapePillar(this));
				    	index ++;
				    	break;
				    }
				    case 2:
				    { 
				    	shapeList.add(new ShapeRightSeven(this));
				    	index ++;
				    	break;
				    }
				    case 3:
				    { 
				    	shapeList.add(new ShapeRightZig(this));
				    	index ++;
				    	break;
				    }
				    case 4:
				    { 
				    	shapeList.add(new ShapeSeven(this));
				    	index ++;
				    	break;
				    }
				    case 5:
				    { 
				    	shapeList.add(new ShapeT(this));
				    	index ++;
				    	break;
				    }
				    case 6:
				    { 
				    	shapeList.add(new ShapeZig(this));
				    	index ++;
				    	break;
				    }
				    
				    default:
				    { 
				    	;
				    }
			    }
			}
			
			if((shapeList.get(index)).isAlive == false) {
				clearBlocks();
			}
		}
	}

	// 计算分数
	private void scoreCalculate() {
		
		continusLineCount = 0;
		int startRow = 0;
		
		for (int i = yPointCount -1; i >= 0; i--) {
			if(blocksOnLine[i] == xPointCount) {
				continusLineCount ++;
				
			} else if (continusLineCount != 0) {          // 若出现连成行的情况，统计分数并更新剩余方块
				socre += Math.pow(2, continusLineCount);
				startRow = i;
				blocksMoveDown(startRow, continusLineCount);      // 更新剩余方块
				continusLineCount = 0; 
			}
		}
		System.out.println("score:" + socre);
	}
	
	// 从指定行 startRow 开始,将所有方块向下移动 rows 行
	private void blocksMoveDown(int startRow, int rows) {
		int positionY;
		int positionX;
		for (int j = startRow; j >=0; j--) {
			for(int i = 0; i < xPointCount; i++	) {         // 此处有待改进，无需对剩余所有行进行移动，只移动有方块的行即可
				if (blockPoint[i][j].isHaveBlock == true) {
					
					// 获取向下 rows 行对应位置点的 X , Y 坐标值
					positionY = blockPoint[i][j + rows].getPositionY();
					positionX = blockPoint[i][j + rows].getPositionX();
					
					// 将方块向下移动到 rows 行
					blockPoint[i][j].getBlock().setPositionY(positionY);
					blockPoint[i][j].getBlock().setLocation(positionX, positionY);
					
					// 将方块对象保存到该位置点上
					blockPoint[i][j + rows].putBlock(blockPoint[i][j].getBlock());
					
					// 使当前位置点变为无方块状态
					blockPoint[i][j].setHaveBlock(false);
				}
			}
		}
	}
	
	// 若有连成一行的方块，删除该行的所有方块
	private void clearBlocks() {
		
		for (int j = yPointCount - 1; j >= 0; j--) {
			blocksOnLine[j] = 0;
			for (int i = 0; i < xPointCount; i++) {
				if (blockPoint[i][j].isHaveBlock == true)
				{
					blocksOnLine[j] ++;
				}
			}
			
			if (blocksOnLine[j] == 0) {
				break;
			} else if(blocksOnLine[j] == xPointCount) {
				clearLine(j);
			}
		}
		repaint();      // 若不调用 repaint，则只能在Panel大小改变之后才重画 Panel上的所有组件
		scoreCalculate();
		validate();
	}

	// 删除指定行上的所有方块
	private void clearLine(int row) {
		for (int i =0; i < xPointCount; i++) {
			blockPoint[i][row].removeBlockFrom(this);
		}
	}
}
