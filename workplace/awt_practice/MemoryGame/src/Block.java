import javax.swing.*;
public class Block extends JButton
{
	private static final long serialVersionUID = 2L;
	ImageIcon openStateIcon;
	
	public ImageIcon getOpenStateIcon()
	{
		return openStateIcon;
	}
	
	public void setOpenStateIcon(ImageIcon icon)
	{
		openStateIcon = icon;
	}
}
