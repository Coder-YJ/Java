import java.awt.*;
import java.awt.event.*;

public class ChessPad extends Panel implements MouseListener,ActionListener
{
	private static final long serialVersionUID = 1L;
	int chessManPoint[][];
	int chessManColor;
	TextField text = new TextField("黑棋先手");
	int xPos, yPos;
	ChessRule chessRule;
	
	public ChessPad() 
	{
		xPos = -1;
		yPos = -1;
		setLayout(null);
		chessManColor = -1;
		setSize(440, 440);
		setBackground(Color.orange);
		
		addMouseListener(this);
		chessRule  = new ChessRule(this);
		chessManPoint = new int[19][19];
		for(int k=0; k<19; k++)
		{
			chessManPoint[k][k] = 0;
		}
		
		add(text);
		text.setBounds(180, 5, 80, 20);
		text.setBackground(Color.white);
		text.setEditable(false);
	}

	public void paint(Graphics g)
	{
		for(int i=40; i<=400; i=i+20)
		{
			g.drawLine(40, i, 400, i);
		}
		for(int i=40; i<=400; i=i+20)
		{
			g.drawLine(i, 40, i, 400);
		}
		g.fillOval(97, 97, 6, 6);
		g.fillOval(337, 97, 6, 6);
		g.fillOval(97, 337, 6, 6);
		g.fillOval(337, 337, 6, 6);
		g.fillOval(217, 217, 6, 6);
	}
	
	public void calculatePosition(int x, int y)
	{

		xPos = (x - 40) / 20;
		yPos = (y - 40) / 20;
		x = (x - 40) % 20;
		y = (y - 40) % 20;
		
		if(x > 10)
		{
			xPos ++; 
		}
		if(y > 10)
		{
			yPos ++;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) 
	{

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		int x = -1, y = -1;
		x = (int)e.getX();
		y = (int)e.getY();
		int a = (x + 10) / 20;
		int b = (y + 10) / 20;
		
		if(e.getModifiers() == InputEvent.BUTTON1_MASK)
		{
			if((x/20 <2) || (y/20 <2) || (x/20 >19) || (y/20 >19))
			{
				;
			}
			else
			{  	
				calculatePosition(x, y);
				chessManPoint[xPos][yPos] = chessManColor;
				ChessMan chessMan = new ChessMan(this);
				add(chessMan);
				chessMan.setBounds(a*20 - 10, b*20 -10, 20, 20);
				if(chessRule.chessReferee())
				{
					if(chessManColor == 1)
					{
						text.setText("白棋胜利！！");
					}
					else if(chessManColor == -1)
					{
						text.setText("黑棋胜利！！");
					}
				}
				else
				{
					if(chessManColor == -1)
					{
						text.setText("请白棋落子");
					}
					else if(chessManColor == 1)
					{
						text.setText("请黑棋落子");
					}
				}
				chessManColor = chessManColor*(-1);
//				System.out.println("xPos: " + xPos + "  yPos: " + yPos);
			}
		}
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
