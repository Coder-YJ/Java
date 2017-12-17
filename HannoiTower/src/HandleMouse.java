import java.awt.*;
import java.awt.event.*;
public class HandleMouse implements MouseListener, MouseMotionListener {

	TowerPoint[] pointA, pointB, pointC;
	TowerPoint startPoint = null; 
	TowerPoint endPoint = null;
	int leftX, leftY;    			// 所选盘子边框所在位置坐标
	int x0, y0;          			// 鼠标按下时在盘子中的坐标
	boolean isMove = false;
	Container con;
	
	public HandleMouse(Container con) {
		// TODO Auto-generated constructor stub
		this.con = con;
	}

	public void setPointA(TowerPoint[] pointA) {
		this.pointA = pointA;
	}
	
	public void setPointB(TowerPoint[] pointB) {
		this.pointB = pointB;
	}
	
	public void setPointC(TowerPoint[] pointC) {
		this.pointC = pointC;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {		
		Disc disc = null;
		disc = (Disc)e.getSource();
		leftX = disc.getBounds().x;
		leftY = disc.getBounds().y;
		int x = e.getX();               // 鼠标按下 和  鼠标移动时的参考坐标系不一样 ？？
		int y = e.getY();
		
		leftX = leftX + x;
		leftY = leftY + y;
		
		if(isMove == true) {
			disc.setLocation(leftX - x0, leftY - y0);    // 为啥要减去 x0 ,y0 ??
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		isMove = false;
		Disc disc = (Disc)e.getSource();
		startPoint = disc.getPoint();
		x0 = e.getX();                     // 鼠标按下 和  鼠标移动时的参考坐标系不一样 ？？
		y0 = e.getY();
		int m = 0;
		
		// 若选中的是 A 塔中盘子，则判断当前所选盘子是否可以移动
		for (int i=0; i<pointA.length; i++) {
			if (pointA[i].equals(startPoint)) {
				m = i;
				if (m > 0 && (pointA[m-1].isHaveDisc() == false)) {   // 若选中的是中间的盘子，还需判断所选盘子的上面是否有其他盘子
					isMove = true;
					break;
				} else if (m == 0) {       // 若选中的是最顶上的盘子，则可以移该盘子
					isMove = true;
					break;
				}
			}
		}
		
		// 同  A 塔
		for (int i=0; i<pointB.length ; i++) {
			if (pointB[i].equals(startPoint)) {
				m = i;
				if (m > 0 && (pointB[m - 1].isHaveDisc() == false)) {
					isMove = true;
					break;
				} else if (m == 0) {
					isMove = true;
					break;
				}
			}
		}
		
		// 同  A 塔
		for (int i=0; i<pointC.length ; i++) {
			if (pointC[i].equals(startPoint)) {
				m = i;
				if (m > 0 && (pointC[m - 1].isHaveDisc() == false)) {
					isMove = true;
					break;
				} else if (m == 0) {
					isMove = true;
					break;
				}
			}
		}
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Disc disc = null;
		disc = (Disc)e.getSource();
		Rectangle rect = disc.getBounds();   // 当前被移动盘子的边框
		boolean location = false;
		int x = -1, y = -1;
		for (int i = 0; i < pointA.length; i++) {
			x = pointA[i].getX();
			y = pointA[i].getY();
			
		//	拖拽结束释放鼠标时判断被拖拽盘子是否落在  A 塔上
			if (rect.contains(x, y)) {
				endPoint = pointA[i];
				if (i == pointA.length - 1 && endPoint.isHaveDisc() == false) {  // 若落在最底端并且最底端没有盘子，则可落在此处
					location = true;
					break;
				} else if (i < pointA.length -1 && pointA[i + 1].isHaveDisc() == true    // 若落除最底端上，并且该处下一个塔点有盘子
						     && endPoint.isHaveDisc() == false                           // 并且当前塔点没有盘子
						     && pointA[i + 1].getDiscOnPoint().getNumber() > disc.getNumber()) {  // 并且下一个盘子的直径比当前盘子要大
					location = true;
					break;
				}
			}
		}
		
		// 逻辑同 A 塔
		for (int i = 0; i < pointB.length; i++) {
			x = pointB[i].getX();
			y = pointB[i].getY();
			
			if (rect.contains(x, y)) {
				endPoint = pointB[i];
				if (i == pointB.length - 1 && endPoint.isHaveDisc() == false) {  // 此处条件需研究
					location = true;
					break;
				} else if (i < pointB.length -1 && pointB[i + 1].isHaveDisc() == true
						     && endPoint.isHaveDisc() == false
						     && pointB[i + 1].getDiscOnPoint().getNumber() > disc.getNumber()) {
					location = true;
					break;
				}
			}
		}
		
		// 逻辑同 A 塔
		for (int i = 0; i < pointC.length; i++) {
			x = pointC[i].getX();
			y = pointC[i].getY();
			
			if (rect.contains(x, y)) {
				endPoint = pointC[i];
				if (i == pointC.length - 1 && endPoint.isHaveDisc() == false) {  // 此处条件需研究
					location = true;
					break;
				} else if (i < pointC.length -1 && pointC[i + 1].isHaveDisc() == true
						     && endPoint.isHaveDisc() == false
						     && pointC[i + 1].getDiscOnPoint().getNumber() > disc.getNumber()) {
					location = true;
					break;
				}
			}
		}
		
		if(endPoint != null && location == true) {  // 如果释放点在 三座塔中并且释放点有效
			endPoint.putDisc(disc, con);
			startPoint.setHaveDisc(false);
		} else {
			startPoint.putDisc(disc, con);
		}
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
