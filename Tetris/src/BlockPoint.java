import java.awt.Point;

public class BlockPoint {

	int positionX, positionY;
	int numberX, numberY;
	boolean isHaveBlock;
	
	public BlockPoint() {
		// TODO Auto-generated constructor stub
		positionX = -1;
		positionY = -1;
		numberX = -1;
		numberY = -1;
		isHaveBlock = false;
	}

	public boolean isHaveBlock() {
		return isHaveBlock;
	}
	
	public void setHaveBlock(boolean boo) {
		isHaveBlock = boo;
	}
	
	public void setPosition(int postionX, int postionY) {
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
	
	public void setNumberY(int numberY) {
		this.numberY = numberY;
	}
	
	public int getNumberY() {
		return numberY;
	}
	
	public void setNumberX(int numberX) {
		this.numberX = numberX;
	}
	
	public int getNumberX() {
		return numberX;
	}
}
