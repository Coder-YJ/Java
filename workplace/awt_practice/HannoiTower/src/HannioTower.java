import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HannioTower extends JFrame implements ActionListener {

	Tower tower = null;
	int amountOfDisc = 10;
	char[] towerName = {'A', 'B', 'C'};
	JMenuBar bar;
	JMenu menuGrade;
	JMenuItem oneGradeItem, twoGradeItem, threeGradeItem;
	JButton renew = null;
	JButton autoButton = null;
	JPanel center = new JPanel();
	
	public HannioTower() {
		// TODO Auto-generated constructor stub
		
		tower = new Tower(towerName);
		tower.setAmountDisc(amountOfDisc);
		tower.setMaxDiscWidth(120);
		tower.setMinDiscWidth(50);
		tower.setDiscHeight(16);
		tower.putDiscOnTower();
		add(tower, BorderLayout.CENTER);
		
		bar = new JMenuBar();
		menuGrade = new JMenu("选择级别");
		oneGradeItem = new JMenuItem("初级");
		twoGradeItem = new JMenuItem("中级");
		threeGradeItem = new JMenuItem("高级");
		menuGrade.add(oneGradeItem);
		menuGrade.add(twoGradeItem);
		menuGrade.add(threeGradeItem);
		bar.add(menuGrade);
		setJMenuBar(bar);
		
		oneGradeItem.addActionListener(this);
		twoGradeItem.addActionListener(this);
		threeGradeItem.addActionListener(this);
		renew = new JButton("重新开始");
		renew.addActionListener(this);
		autoButton = new JButton("自动演示");
		autoButton.addActionListener(this);
		JPanel north = new JPanel();
		north.add(renew);
		north.add(autoButton);
		
		String mess = "将全部盘子从" + towerName[0] + "座搬运到" + towerName[1] + "座或"
		              + towerName[2] + "座";
		
		JLabel hintMessgae = new JLabel(mess, JLabel.CENTER);
		north.add(hintMessgae);
		add(north, BorderLayout.NORTH);
		setResizable(false);
		setVisible(true);
		setBounds(60, 60, 460, 410);
		validate();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == oneGradeItem)
		{
			amountOfDisc = 3;
			tower.setAmountDisc(amountOfDisc);
			tower.putDiscOnTower();
		} else if (e.getSource() == twoGradeItem) {
			amountOfDisc = 4;
			tower.setAmountDisc(amountOfDisc);
			tower.putDiscOnTower();
		} else if (e.getSource() == threeGradeItem) {
			amountOfDisc = 5;
			tower.setAmountDisc(amountOfDisc);
			tower.putDiscOnTower();
		} else if (e.getSource() == renew) {
			tower.setAmountDisc(amountOfDisc);
			tower.putDiscOnTower();
		} else if (e.getSource() == autoButton) {
			tower.setAmountDisc(amountOfDisc);
			tower.putDiscOnTower();
			int x = this.getBounds().x + this.getBounds().width;
			int y = this.getBounds().y;
			tower.getAutoMoveDisc().setLocation(x, y);
			tower.getAutoMoveDisc().setSize(280, getBounds().height);
			tower.getAutoMoveDisc().setVisible(true);
		}
		validate();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HannioTower();
		System.out.println("Get in");
	}

}
