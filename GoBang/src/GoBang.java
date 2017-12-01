import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;

public class GoBang extends Frame 
{
    
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
		setLayout(new BorderLayout());
		add(new ChessPad(),BorderLayout.CENTER);
		setBounds(100, 100, 600, 600);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new GoBang();

	}

}
