import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

/**
 * 
 * @author QYJ
 *
 */

public class TetrisWidow extends JFrame{

	JPanel scorePanel;
	JTextField scoreText;
	JLabel scoreLabel;
	JButton pauseButton;
	public TetrisWidow() {
		// TODO Auto-generated constructor stub
		setBounds(350, 20, 550, 670);
		setLayout(null);
		setTitle("俄罗斯方块");
		
		scorePanel = new JPanel();
		scorePanel.setLayout(new FlowLayout());
		scorePanel.setBounds(425, 30, 100, 150);
		scorePanel.setBackground(new Color(40, 150, 190));
		scoreLabel = new JLabel("分 数");
		scoreLabel.setFont(new Font("新宋体", Font.BOLD, 18));
		scoreText = new JTextField(5);
		scoreText.setFont(new Font("Times", Font.BOLD, 18));
		scoreText.setBackground(new Color(255, 255, 200));
		scoreText.setHorizontalAlignment(JTextField.CENTER);
		pauseButton = new JButton("暂停");
		pauseButton.setFont(new Font("新宋体", Font.BOLD, 17));
		scorePanel.add(scoreLabel);
		scorePanel.add(scoreText);
		scorePanel.add(pauseButton);
		scoreText.setText("0");
		
		
		add(scorePanel);
		
		GamePanel gamePanel = new GamePanel(scoreText, pauseButton);
		add(gamePanel);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TetrisWidow();
	}
	
}
