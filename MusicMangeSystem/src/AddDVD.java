
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddDVD {
	private JFrame frame;
    private JLabel state1_Label;
    private JLabel state2_Label;
   
    private JLabel state4_Label;
    private JLabel state5_Label;
    private JLabel state6_Label;
    private JTextField add1_text;
	private JTextField add2_text;
	
	private JTextField add4_text;
	private JTextField add5_text;
	private JTextField add6_text;
	private JComboBox<Boolean> ownComb = new JComboBox<Boolean>();
	private JButton add_button;
	private JButton add2_button;
	private Database db;
	public AddDVD(Database db) {
		this.db = db;	
		makeFrame();
	}
	private void makeFrame() {
		frame = new JFrame("addDVD");
		JPanel north1 = new JPanel(new GridLayout(5, 2));
		JPanel north2 = new JPanel(new GridLayout(1, 2));
		JLabel state1_Label = new JLabel("导演：");
	    JLabel state2_Label = new JLabel("作品：");
	    
	    JLabel state4_Label = new JLabel("播放时间：");
	    JLabel state5_Label = new JLabel("是否拥有：");
	    JLabel state6_Label = new JLabel("说明：");
	    ownComb.addItem(true);
		ownComb.addItem(false);
	    add_button = new JButton("确认");
	    add_button.addActionListener(
				new ActionListener()
				{
						
					public void actionPerformed(ActionEvent e)
					{
						String title = add1_text.getText();
						String artist = add2_text.getText();
						int playTime = Integer.parseInt(add4_text.getText());
						DVD dvd = new DVD(title, artist,  playTime);
						dvd.setComment(add6_text.getText());
						db.addItem(dvd);
					}
				}
				);
	    add_button.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
			}});
	    
	    add2_button = new JButton("取消");
	    add2_button.addActionListener(
				new ActionListener()
				{
						
					public void actionPerformed(ActionEvent e)
					{
						frame.setVisible(false);
					}
				}
				);
	    add1_text = new JTextField(16);
	    add2_text = new JTextField(16);
	   
	    add4_text = new JTextField(16);
	    add5_text = new JTextField(16);
	    add6_text = new JTextField(16);
	    north1.add(state1_Label);
		north1.add(add1_text);
		north1.add(state2_Label);
		north1.add(add2_text);
		
		north1.add(state4_Label);
		north1.add(add4_text);
		north1.add(state5_Label);
		north1.add(ownComb);
		north1.add(state6_Label);
		north1.add(add6_text);
		north2.add(add_button);
		north2.add(add2_button);
		frame.add(north1,BorderLayout.NORTH);
		frame.add(north2,BorderLayout.SOUTH);
        frame.pack();//调整窗体的大小
        
        // 把窗体放在屏幕的中央并显示
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
