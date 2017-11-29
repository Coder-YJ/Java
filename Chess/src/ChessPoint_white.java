import java.awt.*;
import java.awt.event.*;
public class ChessPoint_white extends Canvas implements MouseListener
{
	ChessPad chessPad = null;
	
	public ChessPoint_white(ChessPad p) 
	{
		setSize(20,20);
		chessPad = p;
		addMouseListener(this);
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.fillOval(0, 0, 20, 20);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount() >=2)
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
		if(e.getModifiers() == InputEvent.BUTTON3_MASK)
		{
			chessPad.remove(this);
			chessPad.棋子颜色 = -1;
			chessPad.text_2.setText("请白棋下子");
			chessPad.text_1.setText("");
		}
	}
	
}
