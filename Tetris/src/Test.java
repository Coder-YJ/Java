import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;

public class Test extends JFrame{

	public Test() {
		// TODO Auto-generated constructor stub
		setBounds(500, 100, 500, 700);
		setLayout(null);
		
		GamePanel gamePanel = new GamePanel();
		add(gamePanel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Test();
	}
	
}
