import javax.swing.*;
import java.awt.*;
/**
 * 用于表示一个盘子，每个盘子对应有一个 TowerPoint 对象，用于表示该盘子在一座塔中的位置
 * 
 * @author CoderYJ
 * @date   2017.12.16
 *
 */
public class Disc extends JButton{

	int number;
	TowerPoint point;
	
	public Disc() {
		// TODO Auto-generated constructor stub
		setBackground(Color.cyan);
	}
	
	public void setNumber(int n) {
		number = n;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setPoint(TowerPoint p) {
		point = p;
	}
	
	public TowerPoint getPoint() {
		return point;
	}
	
}
