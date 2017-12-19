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
			if(((ShapeRightSeven)shapeList.get(index)) != null && ((ShapeRightSeven)shapeList.get(index)).isAlive == true) {
				((ShapeRightSeven)shapeList.get(index)).goLeft();
			}
			System.out.println("Get in VK_LEFT");
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(((ShapeRightSeven)shapeList.get(index)) != null && ((ShapeRightSeven)shapeList.get(index)).isAlive == true) {
				((ShapeRightSeven)shapeList.get(index)).goRight();
			}
			System.out.println("Get in VK_RIGHT");
		}
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(((ShapeRightSeven)shapeList.get(index)) != null && ((ShapeRightSeven)shapeList.get(index)).isAlive == true) {
				((ShapeRightSeven)shapeList.get(index)).goDown();
			}
			System.out.println("Get in VK_DOWN");
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(((ShapeRightSeven)shapeList.get(index)) != null && ((ShapeRightSeven)shapeList.get(index)).isAlive == true) {
				((ShapeRightSeven)shapeList.get(index)).changeShape();
			}
			System.out.println("Get in VK_UP");
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
			    switch (whichKindShapw) {
				    case 0:
				    { 
				    	shapeList.add(new ShapeMatts(this));
				    	index ++;
				    	break;
				    }
				    case 1:
				    { 
				    	shapeList.add(new ShapeMatts(this));
				    	index ++;
				    	break;
				    }
				    case 2:
				    { 
				    	shapeList.add(new ShapeMatts(this));
				    	index ++;
				    	break;
				    }
				    case 3:
				    { 
				    	shapeList.add(new ShapeMatts(this));
				    	index ++;
				    	break;
				    }
				    default:
				    { 
				    	;
				    }
			    }
				shapeList.add(new ShapeRightSeven(this));
				
			}
			
		}
			
	}

}
