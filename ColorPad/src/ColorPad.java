import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class ColorPad extends JFrame implements ActionListener, MouseListener{

	JPanel colorPanel;
	JPanel valuePanel;
	JTextField colorText;
	int red;
	int green;
	int blue;
	
	public ColorPad() {
		// TODO Auto-generated constructor stub
		setBounds(350, 20, 550, 670);
		setLayout(null);
		setTitle("È¡É«°å");
		
		colorPanel = new JPanel();
		valuePanel = new JPanel();
		colorText = new JTextField(11);
		colorPanel.setLayout(new FlowLayout());
		valuePanel.setBounds(450, 0, 150, 670);
		colorPanel.setBounds(0, 0, 450, 670);
		valuePanel.add(colorText);
		
		valuePanel.setBackground(Color.gray);
		add(colorPanel, BorderLayout.CENTER);
		add(valuePanel, BorderLayout.EAST);
		
		createColorPanel();
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createColorPanel() {
		for (int red = 0; red < 255; red = red + 10) {
			for (int green = 0; green < 255; green = green + 10) {
				for (int blue = 0; blue < 255; blue = blue + 10) {
					colorPanel.add(new ColorPoint(this, red, green, blue));
				}
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() instanceof ColorPoint) {
//			int red = ((ColorPoint)e.getSource()).red;
//			int green = ((ColorPoint)e.getSource()).green;
			int red = ((ColorPoint)e.getSource()).getBounds().width;
			int green = ((ColorPoint)e.getSource()).getBounds().height;
			int blue = ((ColorPoint)e.getSource()).blue;
			colorText.setText("("+ red + " ," + green + " ," + blue + ")");
		}

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new ColorPad();
	}

}
