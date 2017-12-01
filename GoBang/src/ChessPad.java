import java.awt.*;
import java.awt.event.*;

public class ChessPad extends Panel implements MouseListener,ActionListener
{

	int chessManPoint[][];
	
	public ChessPad() 
	{
		setSize(400, 400);
		setBackground(Color.orange);
		validate();
	}

	public void paint(Graphics g)
	{
		for(int i=40; i<=360; i=i+20)
		{
			g.drawLine(40, i, 360, i);
		}
		for(int i=40; i<=360; i=i+20)
		{
			g.drawLine(i, 40, i, 360);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
