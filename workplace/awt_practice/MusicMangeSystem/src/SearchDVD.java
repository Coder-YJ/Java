import java.awt.BorderLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class SearchDVD {
	private JFrame frame;
    private JLabel state1_Label = new JLabel("导演：");
    private JLabel state2_Label = new JLabel("作品：");
   
    private JLabel state4_Label = new JLabel("播放时间：");
    private JLabel state5_Label = new JLabel("是否拥有：");
    private JLabel state6_Label = new JLabel("说明：");
    private JTextField add1_text = new JTextField(16);
	private JTextField add2_text = new JTextField(16);
	
	private JTextField add4_text = new JTextField(16);
	private JTextField add5_text = new JTextField(16);
	private JTextField add6_text = new JTextField(16);
	private JComboBox<Boolean> ownComb = new JComboBox<Boolean>();
	private JButton add_button;
	private JButton add2_button;
	private Database db;
	private JPanel searchBar = new JPanel();
	private JTextField txtSearchId = new JTextField(10);
	public SearchDVD(Database db) {
		this.db = db;	
		makeFrame();
	}
	private void makeFrame() {
		frame = new JFrame("DVD");
		JPanel north1 = new JPanel(new GridLayout(5, 2));
		JPanel north2 = new JPanel(new GridLayout(1, 2));
		JPanel north3 = new JPanel(new GridLayout(1, 2));
		ownComb.addItem(true);
		ownComb.addItem(false);
	   
	    searchBar.add(new JLabel("作品："));
		searchBar.add(this.txtSearchId);
		
		add_button = new JButton("确认");
	    add_button.addActionListener(new ActionListener(){	
					public void actionPerformed(ActionEvent e)
					{
						String i = txtSearchId.getText();
						String j = db.searchDVD(i).getTitle();
						if(i.equals(j)){
								DVD t = db.searchDVD(i);	
								// 应该是对 add1_text设置文本，而不是重新定义 string变量
								System.out.println(t.getDirector());
								add1_text.setText("" + t.getDirector());
								add2_text.setText(t.getTitle());	
								
								add4_text.setText("" + t.getPlayingTime());
								System.out.println("输出时间：" + t.getPlayingTime());
								
								
								if(t.getOwn().equals("拥有"))
									t.setOwn(true);
								else
									t.setOwn(false);
								
								add6_text.setText("" + t.getComment());
								
						}
					}
				}
				);
	    
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
		
		north1.add(state4_Label);
		north1.add(add4_text);
		north1.add(state5_Label);
		north1.add(ownComb);
		north1.add(state6_Label);
		north1.add(add6_text);
		north2.add(add_button);
		north2.add(add2_button);
		north3.add(searchBar);
		north3.add(txtSearchId);
		frame.add(north1,BorderLayout.CENTER);
		frame.add(north3,BorderLayout.NORTH);
		frame.add(north2,BorderLayout.SOUTH);
		
        frame.pack();//调整窗体的大小
        
        // 把窗体放在屏幕的中央并显示
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
       
       
        
	}


}
