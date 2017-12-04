import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;

public class GoBang extends Frame implements ActionListener
{
    Button b_rNew = new Button("重新开始");
    ChessPad  chessPad;
	public GoBang() 
	{
		// TODO Auto-generated constructor stub
		setLayout(null);
		setTitle("五子棋");
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		chessPad = new ChessPad();
		chessPad.setBounds(70, 70, 440, 440); 
		add(chessPad);
		setBounds(100, 100, 600, 600);
		
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new GoBang();

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}

}
