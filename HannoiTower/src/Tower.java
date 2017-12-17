import javax.activation.MailcapCommandMap;
import javax.swing.*;
import java.awt.*;

public class Tower extends JPanel{

	int amoutOfDisc = 3;
	Disc[] disc;
	int maxDiscWidth, minDiscWidth, discHeight;
	char[] towerName;
	TowerPoint[] pointA, pointB, pointC;
	HandleMouse handleMouse;
	AutoMoveDisc autoMoveDisc;
	
	public Tower(char[] towerName) {
		// TODO Auto-generated constructor stub
		handleMouse = new HandleMouse(this);
		this.towerName = towerName;
		setLayout(null);
		setBackground(new Color(200, 226, 226));
		
	}
	
	public void setAmountDisc(int number) {
		if(number <= 1) {
			amoutOfDisc = 1;
		} else {
			amoutOfDisc = number;
		}
	}

	public void setMaxDiscWidth(int m) {
		maxDiscWidth = m;
	}
	
	public void setMinDiscWidth(int m) {
		minDiscWidth = m;
	}
	
	public void setDiscHeight(int h) {
		discHeight = h;
	}
	
	public AutoMoveDisc getAutoMoveDisc() {
		return autoMoveDisc;
	}
	
	public void putDiscOnTower() {
		
		removeDisc();
		int n = (maxDiscWidth - minDiscWidth) / amoutOfDisc;
		disc = new Disc[amoutOfDisc];
		
		// 创建盘子，绑定监听器
		for (int i = 0; i< disc.length; i++) {
			disc[i] = new Disc();
			disc[i].setNumber(i);
			int discWidth = minDiscWidth + (i * n);
			disc[i].setSize(discWidth, discHeight);
			disc[i].addMouseListener(handleMouse);
			disc[i].addMouseMotionListener(handleMouse);
		}
		
		pointA = new TowerPoint[amoutOfDisc];
		pointB = new TowerPoint[amoutOfDisc];
		pointC = new TowerPoint[amoutOfDisc];
		
		// 设置  A、B、C 三组塔点的坐标
		int vertialDistance = discHeight;
		for (int i = 0; i < pointA.length; i++) {
			pointA[i] = new TowerPoint(maxDiscWidth,  100 + vertialDistance);
			vertialDistance = vertialDistance + discHeight;
		}
		
	    vertialDistance = discHeight;
		for (int i = 0; i < pointB.length; i++) {
			pointB[i] = new TowerPoint(2 * maxDiscWidth,  100 + vertialDistance);
			vertialDistance = vertialDistance + discHeight;
		}
		
		vertialDistance = discHeight;
		for (int i = 0; i < pointC.length; i++) {
			pointC[i] = new TowerPoint(3 * maxDiscWidth,  100 + vertialDistance);
			vertialDistance = vertialDistance + discHeight;
		}
		
		// 将盘子放在  A 组的塔点上
		for(int i = 0; i < pointA.length; i++) {
			pointA[i].putDisc(disc[i], this);
		}
		
	    // 为 handleMouse 和 autoMoveDisc传递塔点对象
		handleMouse.setPointA(pointA);
		handleMouse.setPointB(pointB);
		handleMouse.setPointC(pointC);
		autoMoveDisc = new AutoMoveDisc(this);
		autoMoveDisc.setTowerName(towerName);
		autoMoveDisc.setAmountOfDisc(amoutOfDisc);
		autoMoveDisc.setPointA(pointA);
		autoMoveDisc.setPointB(pointB);
		autoMoveDisc.setPointC(pointC);
		
		validate();
		repaint();            // 了解 repaint() 的调用情况
	}
	
	public void removeDisc() {
		if (pointA != null) {
			for (int i = 0; i < pointA.length; i++) {
				pointA[i].removeDisc(pointA[i].getDiscOnPoint(), this);
				pointB[i].removeDisc(pointB[i].getDiscOnPoint(), this);
				pointC[i].removeDisc(pointC[i].getDiscOnPoint(), this);
			}
		}
	}
	
	public void paintComponent(Graphics g) {   // 了解 paintComponent 函数
		
		super.paintComponent(g);
		int x1, y1, x2, y2;
		// 绘制 A 塔的竖直线
		x1 = pointA[0].getX();
		y1 = pointA[0].getY() - (discHeight / 2);
		x2 = pointA[amoutOfDisc - 1].getX();
		y2 = pointA[amoutOfDisc - 1].getY()  + (discHeight/2);
		g.drawLine(x1, y1, x2, y2);
		
		// 绘制 B 塔的竖直线
		x1 = pointB[0].getX();
		y1 = pointB[0].getY() - (discHeight / 2);
		x2 = pointB[amoutOfDisc - 1].getX();
		y2 = pointB[amoutOfDisc - 1].getY()  + (discHeight/2);
		g.drawLine(x1, y1, x2, y2);
		
		// 绘制 C 塔的竖直线
		x1 = pointC[0].getX();
		y1 = pointC[0].getY() - (discHeight / 2);
		x2 = pointC[amoutOfDisc - 1].getX();
		y2 = pointC[amoutOfDisc - 1].getY()  + (discHeight/2);
		g.drawLine(x1, y1, x2, y2);
		
		// 绘制塔底座
		g.setColor(Color.blue);
		x1 = pointA[amoutOfDisc - 1].getX() - (maxDiscWidth /2);
		y1 = pointA[amoutOfDisc - 1].getY() + (discHeight / 2);
		x2 = pointC[amoutOfDisc - 1].getX() + (maxDiscWidth /2);
		y2 = pointC[amoutOfDisc - 1].getY() + (discHeight / 2);
		int length = x2 -x1, height = 6;
		g.fillRect(x1, y1, length, height);
		
		// 绘制塔中竖直线上的圆点
		int size = 6;
		for (int i = 0; i < pointA.length; i++) {
			g.fillOval(pointA[i].getX() - size/2, pointA[i].getY() - size/2, size, size);
			g.fillOval(pointB[i].getX() - size/2, pointB[i].getY() - size/2, size, size);
			g.fillOval(pointC[i].getX() - size/2, pointC[i].getY() - size/2, size, size);
		}
		// 绘制每座塔的名称
		g.drawString(towerName[0] + "座", pointA[amoutOfDisc - 1].getX() - 10, pointA[amoutOfDisc - 1].getY() + 30);
		g.drawString(towerName[1] + "座", pointB[amoutOfDisc - 1].getX() - 10, pointB[amoutOfDisc - 1].getY() + 30);
		g.drawString(towerName[2] + "座", pointC[amoutOfDisc - 1].getX() - 10, pointC[amoutOfDisc - 1].getY() + 30);
		
	}
}
