import java.awt.Component;
import java.awt.Container;
import java.awt.Point;

import javax.swing.JPanel;

public class BlockPoint {

	int positionX, positionY;
	int numberX, numberY;
	boolean isHaveBlock;
	Block block;
	
	public BlockPoint() {
		// TODO Auto-generated constructor stub
		positionX = -1;
		positionY = -1;
		numberX = -1;
		numberY = -1;
		isHaveBlock = false;
		block = new Block();
	}

	public void putBlock(Block block) {
		this.block = block;
		isHaveBlock = true;
	}
	
	public Block getBlock() {
		return block;
	}
	
	public boolean isHaveBlock() {
		return isHaveBlock;
	}
	
	public void setHaveBlock(boolean boo) {
		isHaveBlock = boo;
	}
	
	public boolean removeBlockFrom(JPanel con) 
	{
		if(isHaveBlock)
		{
			con.remove(block);
			isHaveBlock = false;
			return true;
		} else {
			return false;
		}
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
