import java.awt.*;
import javax.swing.*;
import javax.swing.text.Position;
public class Block extends JButton{

	int positionX, positionY;
	int number;
	int size;
	
	public Block() {
		// TODO Auto-generated constructor stub
		positionX = -1;
		positionY = -1;
		number = -1;
		size = 20;
		setBackground(new Color(220, 220 , 0));
		setSize(size, size);
		setEnabled(false);
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setPositon(int postionX, int postionY) {
		this.positionX = postionX;
		this.positionY = postionY;
	}

	public Point getPostion()
	{
		return new Point(positionX ,positionY);
	}
	
	public void setPositionX(int positionX)
	{
		this.positionX = positionX;
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	public int getPositionY() {
		return positionY;
	}
}
