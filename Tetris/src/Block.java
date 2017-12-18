import java.awt.*;
import javax.swing.*;
import javax.swing.text.Position;
public class Block extends JButton{

	int postionX, postionY;
	int number;
	
	public Block() {
		// TODO Auto-generated constructor stub
		postionX = -1;
		postionY = -1;
		number = -1;
		setBackground(new Color(220, 220 , 0));
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setPositon(int postionX, int postionY) {
		this.postionX = postionX;
		this.postionY = postionY;
	}

	public Point getPostion()
	{
		return new Point(postionX ,postionY);
	}
	
	public void setPositionX(int positionX)
	{
		this.postionX = positionX;
	}
	
	public int getPositionX() {
		return postionX;
	}
	
	public void setPositionY(int positionY) {
		this.postionY = positionY;
	}
	
	public int getPositionY() {
		return postionY;
	}
}
