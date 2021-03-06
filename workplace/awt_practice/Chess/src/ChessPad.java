import java.awt.*;
import java.awt.event.*;
//创建棋盘的类
class ChessPad extends Panel implements MouseListener,ActionListener
{

	int x = -1, y = -1, 棋子颜色 = 1;
	Button button = new Button("重新开局");
	TextField text_1 = new TextField("请黑棋下子"),
			  text_2 = new TextField();
	
	ChessPad() 
	{
		setSize(440, 440);
		setLayout(null);
		setBackground(Color.orange);
		addMouseListener(this);
		add(button);
		button.setBounds(10, 5, 60, 26);
		button.addActionListener(this);
		add(text_1);
		text_1.setBounds(90, 5, 90, 24);
		add(text_2);
		text_2.setBounds(290, 5, 90, 24);
		text_1.setEditable(false);
		text_2.setEditable(false);
		
	}
	
	public void paint(Graphics g)
	{
		for(int i=40; i<=380; i=i+20)
		{
			g.drawLine(40, i, 400, i);
		}
		g.drawLine(40, 400, 400, 400);
		for(int j=40; j<=380; j=j+20)
		{
			g.drawLine(j, 40, j, 400);
		}
		g.drawLine(400, 40, 400, 400);
		g.fillOval(97, 97, 6, 6);
		g.fillOval(337, 97, 6, 6);
		g.fillOval(97, 337, 6, 6);
		g.fillOval(337, 337, 6, 6);
		g.fillOval(217, 217, 6, 6);
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		if(e.getModifiers() == InputEvent.BUTTON1_MASK)
		{
			x = (int)e.getX();
			y = (int)e.getY();
			ChessPoint_black chesspoint_black = new ChessPoint_black(this);
			ChessPoint_white chesspoint_white = new ChessPoint_white(this);
			int a = (x+10)/20;
			int b = (y+10)/20;
			if(x/20<2 || y/20<2 || x/20>19 || y/20>19)
			{
				;
			}
			else
			{
				if(棋子颜色  == 1)
				{
					this.add(chesspoint_black);
					chesspoint_black.setBounds(a*20-10, b*20-10, 20, 20);
					棋子颜色 = 棋子颜色*(-1);
					text_2.setText("请白棋下子");
					text_1.setText("");
				}
				else if(棋子颜色 == -1)
				{
					this.add(chesspoint_white);
					chesspoint_white.setBounds(a*20-10, b*20-10, 20, 20);
					棋子颜色 = 棋子颜色*(-1);
					text_2.setText("");
					text_1.setText("请黑棋下子");
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.removeAll();
		棋子颜色 = 1;
		add(button);
		button.setBounds(10, 5, 60, 26);
		add(text_1);
		text_1.setBounds(90, 5, 90, 24);
		text_2.setText("");
		text_1.setText("请黑棋下子");
		add(text_2);
		text_2.setBounds(290, 5, 90, 24);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
