import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BallotsCount 
{
	public static void main(String[] args) 
	{
		SelectWindow win = new SelectWindow();
		win.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}

}
