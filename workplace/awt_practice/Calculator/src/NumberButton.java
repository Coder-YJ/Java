import java.awt.Color;
import javax.swing.*;

public class NumberButton extends JButton{

	int number;
	public NumberButton(int number) {
		// TODO Auto-generated constructor stub
		super("" + number);
		this.number = number;
		setForeground(Color.blue);
	}
	
	public int getNumber() {
		return number;
	}
}
