import java.awt.*;
import java.awt.event.*;

public class ChessMan extends Canvas implements MouseListener
{
	int chessManColor;
	ChessMan(int chessManColor) 
	{
		// TODO Auto-generated constructor stub
		this.chessManColor = chessManColor;
		setSize(20, 20);
	}

	public void paint(Graphics g)
	{
		if(chessManColor == -1)
		{
			g.setColor(Color.black);
			g.fillOval(0, 0, 20, 20);
		}
		else if(chessManColor == 1)
		{
			g.setColor(Color.white);
			g.fillOval(0, 0, 20, 20);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
