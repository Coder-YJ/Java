import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 * 
 * @author QYJ
 *
 */

public class TetrisWidow extends JFrame{

	public TetrisWidow() {
		// TODO Auto-generated constructor stub
		setBounds(500, 100, 500, 700);
		setLayout(null);
		
		GamePanel gamePanel = new GamePanel();
		add(gamePanel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TetrisWidow();
	}
	
}
