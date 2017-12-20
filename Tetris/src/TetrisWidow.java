import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 * 俄罗斯方块，已完成 百分之八十，未完成功能： 消除连成行的方块后对剩余方块位置的更新
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
