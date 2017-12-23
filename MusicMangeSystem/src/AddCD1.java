
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



public class AddCD1 {
		private JFrame frame;
		private JLabel state1_Label = new JLabel("歌手：");
	    private JLabel state2_Label = new JLabel("专辑：");
	    private JLabel state3_Label = new JLabel("曲目数量：");
	    private JLabel state4_Label = new JLabel("播放时间：");
	    private JLabel state5_Label = new JLabel("是否拥有：");
	    private JLabel state6_Label = new JLabel("说明：");
	    private JTextField add1_text = new JTextField(16);
		private JTextField add2_text = new JTextField(16);
		private JTextField add3_text = new JTextField(16);
		private JTextField add4_text = new JTextField(16);
		private JTextField add5_text = new JTextField(16);
		private JTextField add6_text = new JTextField(16);
		private JComboBox<Boolean> ownComb = new JComboBox<Boolean>();
		private JButton add_button = new JButton("确认");
		private JButton add2_button = new JButton("取消");
		private Database db;
		public AddCD1(Database db) {
			this.db = db;
			makeFrame();
		}
		private void makeFrame() {
			
	        frame = new JFrame("CD");
			JPanel north1 = new JPanel(new GridLayout(6, 2));
			JPanel north2 = new JPanel(new GridLayout(1, 2));
			ownComb.addItem(true);
			ownComb.addItem(false);
		    
		    add_button = new JButton("确认");
		    add_button.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e)
						{
							
							String artist = add2_text.getText();
							System.out.println("artist: " + artist);
							String title = add1_text.getText();
							int num = Integer.parseInt(add3_text.getText());
							int playTime = Integer.parseInt(add4_text.getText());
							System.out.println("输入时间" + playTime);
							CD cd = new CD(title, artist, num, playTime);
							cd.setComment(add6_text.getText());
							db.addItem(cd);
							
							System.out.println("已经添加");
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
		    north1.add(state1_Label);
			north1.add(add1_text);
			north1.add(state2_Label);
			north1.add(add2_text);
			north1.add(state3_Label);
			north1.add(add3_text);
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
	        frame.setVisible(true);
		}
//		public static void main(String[] args) {
//			// TODO Auto-generated method stub
//			//new AddCD1();
//		}

}
