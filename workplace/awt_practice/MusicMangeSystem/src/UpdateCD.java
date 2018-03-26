
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateCD {
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
	private JButton add_button = new JButton("确认");
	private JButton add2_button = new JButton("取消");
	private Database db=new Database();;
	private JPanel searchBar = new JPanel();
	private JTextField txtSearchId = new JTextField(10);
	
    ///////  添加构造函数，用于接收 db 对象
	public  UpdateCD (Database db) {
		this.db = db;
		makeFrame();
	}
   
		
	
	private void makeFrame() {
		
        frame = new JFrame("CD");
		JPanel north1 = new JPanel(new GridLayout(6, 2));
		JPanel north2 = new JPanel(new GridLayout(1, 2));
		JPanel north3 = new JPanel(new GridLayout(1, 2));
		
	    
	    
	    searchBar.add(new JLabel("专辑："));
		searchBar.add(this.txtSearchId);
		searchBar.add(add_button);
		//给按钮注册事件侦听器
		add_button.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
						String i = txtSearchId.getText();
						String j = db.searchCD(i).getTitle();
						
						if(i.equals(j)){
								CD t = db.searchCD(i);	
								// 应该是对 add1_text设置文本，而不是重新定义 string变量
								System.out.println(t.getArtist());
								add1_text.setText("" + t.getArtist());
								add2_text.setText(t.getTitle());	
								add3_text.setText("" + t.getNumberOfTracks());
								add4_text.setText("" + t.getPlayingTime());
								System.out.println("输出时间：" + t.getPlayingTime());
								
								
								
								add6_text.setText("" + t.getComment());
								db.updateCD(t);
//						       
						}
						
					}
				}
				);
		add_button.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
								String i = txtSearchId.getText();
								CD t = db.searchCD(i);	
								
								db.updateCD(t);
//						       
						
						
					}
				}
				);
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
		north1.add(add5_text);
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
