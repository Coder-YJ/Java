import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;

public class GoBang extends Frame 
{
    Button button1 = new Button("确定");
    ChessPad  chessPad;
	public GoBang() 
	{
		// TODO Auto-generated constructor stub
		
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setLayout(null);
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

}
