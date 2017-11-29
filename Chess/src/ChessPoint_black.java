import java.awt.*;
import java.awt.event.*;

public class ChessPoint_black extends Canvas implements MouseListener
{

	ChessPad chessPad = null;      //棋子所在棋盘
	ChessPoint_black(ChessPad p)
	{
		setSize(20, 20);
		chessPad = p;
		addMouseListener(this);
	}

	public void paint(Graphics g)  //绘制棋子的大小
	{
		g.setColor(Color.black);
		g.fillOval(0, 0, 20, 20);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getModifiers() == InputEvent.BUTTON3_MASK)
		{
			chessPad.remove(this);
			chessPad.棋子颜色 = 1;
			chessPad.text_2.setText("");
			chessPad.text_1.setText("请黑棋下子");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
