import java.awt.*;
import java.awt.event.*;

public class ChessMan extends Canvas implements MouseListener
{
	int chessManColor;
	ChessPad chessPad;
	ChessMan(ChessPad chessPad) 
	{
		// TODO Auto-generated constructor stub
		chessManColor = chessPad.chessManColor;
		this.chessPad = chessPad;
		addMouseListener(this);
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
	public void mouseClicked(MouseEvent e) 
	{
		if(e.getClickCount() >= 2)
		{
			chessPad.remove(this);
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
