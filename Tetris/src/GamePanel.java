import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	int blockSize = 20;       // 方块尺寸
	int xPointCount, yPointCount;
	BlockPoint[][] blockPoint;
	Timer timer;
	
	// test
	ShapeMatts sm;
	ArrayList<ShapeMatts> shapeList;
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
		createBlockPoint();
		
		sm = new ShapeMatts(this);
		addKeyListener(this);
		validate();
		setFocusable(true);        // 需要设置可获取输入焦点，否则键盘事件无法响应;
		
		// test
		shapeList = new ArrayList<ShapeMatts>();
		shapeList.add(new ShapeMatts(this));
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
			System.out.println("Get in VK_KP_LEFT");
			if(((ShapeMatts)shapeList.get(index)) != null && ((ShapeMatts)shapeList.get(index)).isAlive == true) {
				((ShapeMatts)shapeList.get(index)).goLeft();
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(((ShapeMatts)shapeList.get(index)) != null && ((ShapeMatts)shapeList.get(index)).isAlive == true) {
				((ShapeMatts)shapeList.get(index)).goRight();
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
		if (e.getSource() == timer) {
			
			if(((ShapeMatts)shapeList.get(index)).isAlive)
			{
				((ShapeMatts)shapeList.get(index)).goDown();
			} else {
				shapeList.add(new ShapeMatts(this));
				index ++;
			}
			
		}
			
	}

}
