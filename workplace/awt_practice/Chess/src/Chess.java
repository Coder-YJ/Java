import java.awt.*;
import java.awt.event.*;

public class Chess extends Frame 
{
	ChessPad chesspad = new ChessPad();
	Chess()
	{
		setVisible(true);
		setLayout(null);
		Label label = new Label("单击左键下棋子，双击吃棋子，右键单击悔棋",Label.CENTER);
		add(label);
		label.setBounds(70, 55, 440, 26);
		label.setBackground(Color.orange);
		add(chesspad);
		chesspad.setBounds(70, 90, 440, 440);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		pack();
		setSize(600, 500);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chess chess = new Chess();
	}

}
