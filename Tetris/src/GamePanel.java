import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	int blockSize = 20;       // 方块尺寸
	int xPointCount, yPointCount;
	BlockPoint[][] blockPoint;
	Timer timer;
	Random random;
	int[] blocksOnLine;
	
	
	// test
	ShapeMatts sm;
	ArrayList<Shape> shapeList;
	int index = 0;
	
	public GamePanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		xPointCount = 20;
		yPointCount = 30;
		setBounds(10, 10, xPointCount * blockSize, yPointCount * blockSize);
		setBackground(new Color(100, 220, 200));
		
		timer = new Timer(1000, this);
		timer.setInitialDelay(500);
		timer.start();
		random = new Random();
		createBlockPoint();
		
		blocksOnLine = new int[yPointCount];
//		sm = new ShapeMatts(this);
		addKeyListener(this);
		validate();
		setFocusable(true);        // 需要设置可获取输入焦点，否则键盘事件无法响应;
		
		// test
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
//			System.out.println("Get in VK_LEFT");
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if((shapeList.get(index)) != null && (shapeList.get(index)).isAlive == true) {
				(shapeList.get(index)).goRight();
			}
//			System.out.println("Get in VK_RIGHT");
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if((shapeList.get(index)) != null && (shapeList.get(index)).isAlive == true) {
				(shapeList.get(index)).goDown();
			}
//			System.out.println("Get in VK_DOWN");
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if((shapeList.get(index)) != null && (shapeList.get(index)).isAlive == true) {
				(shapeList.get(index)).changeShape();
			}
//			System.out.println("Get in VK_UP");
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
		if (e.getSource() == timer) {
			
			if((shapeList.get(index)).isAlive){
				
				(shapeList.get(index)).goDown();
			} else {
				
			    random.setSeed(System.currentTimeMillis());
			    int whichKindShapw = random.nextInt(7);
//			    System.out.println("whichKindShapw: " + whichKindShapw);
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
			
			clearBlocks();
		}
	}

	// 消除整行方块后更新剩余方块
	private void update() {
		
	}
	
	private void scoreCalculate() {
		
	}
	
	private void clearBlocks() {
		
//		for (int i = 0; i < yPointCount; i++) {
//			blocksOnLine[i] = 0;
//		}
		
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
		
		validate();
	}
	
	private void clearLine(int row) {
		for (int i =0; i < xPointCount; i++) {
//			blockPoint[i][row].removeBlockFrom(this);
			System.out.println("blockPoint["+i+"]["+row+"]： " + blockPoint[i][row].getBlock());
			remove( blockPoint[i][row].getBlock());
		}
	}
}
