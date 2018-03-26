import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ChessPad extends Panel implements MouseListener,ActionListener
{
	private static final long serialVersionUID = 1L;
	int chessManPoint[][];              //棋子状态，棋盘上所有交叉点的状态，棋子落下后对应交叉点状态会相应的发生变化。
	int chessManColor;                  //棋子颜色
	int xPos, yPos;                     //棋子在棋盘中的位置
	boolean isVictory;                  //是否出现赢棋情况
	JTextField text = new JTextField();  
	JButton b_rNew = new JButton("重新开始");
	ChessRule chessRule;                       //判断规则
	
	public ChessPad() 
	{
		setLayout(null);
		setSize(440, 440);
		setBackground(Color.orange);
		addMouseListener(this);
		init();

	}
	
	public void  init()
	{
		xPos = -1;
		yPos = -1;
		chessManColor = -1;
		isVictory = false;
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
		text.setHorizontalAlignment(JTextField.CENTER);
		text.setVisible(true);
		text.setText("黑棋先手");

		add(b_rNew);
		b_rNew.setBounds(170, 410, 100, 29);
		b_rNew.addActionListener(this);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		for(int i=40; i<=400; i=i+20)    //绘制棋盘网格线
		{
			g.drawLine(40, i, 400, i);
		}
		for(int i=40; i<=400; i=i+20)   
		{
			g.drawLine(i, 40, i, 400);
		}
		g.fillOval(97, 97, 6, 6);       //绘制棋盘锚点
		g.fillOval(337, 97, 6, 6);
		g.fillOval(97, 337, 6, 6);
		g.fillOval(337, 337, 6, 6);
		g.fillOval(217, 217, 6, 6);
	}
	
/*  函数名称：calculatePosition()
 * 	参数：   x 鼠标单击点在棋盘中的  x 坐标
 *       y 鼠标单击点在棋盘中的  y 坐标
 *  返回值：void
 *  功能：挡在棋盘中单击鼠标落子时，计算出落子点在棋盘中的位置。
 *  创建信息：2017.12.3  By Coder-YJ
 */
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
			if((x/20 <2) || (y/20 <2) || (x/20 >19) || (y/20 >19))   // 判断鼠标点击位置是否在棋盘网格线范围内
			{
				;
			}
			else if(!isVictory)
			{  	
				calculatePosition(x, y);
				chessManPoint[xPos][yPos] = chessManColor;
				ChessMan chessMan = new ChessMan(this);             //创建棋子
				add(chessMan);
				chessMan.setBounds(a*20 - 10, b*20 -10, 20, 20);    //设置棋子坐标
				
				if(chessRule.chessReferee())                        //判断是否出现赢棋的情况
				{
					if(chessManColor == 1)
					{
						text.setText("白棋胜利!");
					}
					else if(chessManColor == -1)
					{
						text.setText("黑棋胜利!");
					}
					text.setBackground(Color.red);
					isVictory = true;
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
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == b_rNew)
		{
			this.removeAll();
			init();
		}
	}

}
