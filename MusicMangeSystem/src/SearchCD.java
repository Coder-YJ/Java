
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;


public class SearchCD {
	private JFrame frame;
    private JLabel state1_Label = new JLabel("���֣�");
    private JLabel state2_Label = new JLabel("ר����");
    private JLabel state3_Label = new JLabel("��Ŀ������");
    private JLabel state4_Label = new JLabel("����ʱ�䣺");
    private JLabel state5_Label = new JLabel("�Ƿ�ӵ�У�");
    private JLabel state6_Label = new JLabel("˵����");
    private JTextField add1_text = new JTextField(16);
	private JTextField add2_text = new JTextField(16);
	private JTextField add3_text = new JTextField(16);
	private JTextField add4_text = new JTextField(16);
	private JTextField add5_text = new JTextField(16);
	private JTextField add6_text = new JTextField(16);
	private JComboBox<Boolean> ownComb = new JComboBox<Boolean>();
	private JButton add_button = new JButton("ȷ��");
	private JButton add2_button = new JButton("ȡ��");
	private Database db=new Database();;
	private JPanel searchBar = new JPanel();
	private JTextField txtSearchId = new JTextField(10);
	
    ///////  ��ӹ��캯�������ڽ��� db ����
	public  SearchCD (Database db) {
		this.db = db;
		makeFrame();
	}
   
		
	
	private void makeFrame() {
		
        frame = new JFrame("CD");
		JPanel north1 = new JPanel(new GridLayout(6, 2));
		JPanel north2 = new JPanel(new GridLayout(1, 2));
		JPanel north3 = new JPanel(new GridLayout(1, 2));
		ownComb.addItem(true);
		ownComb.addItem(false);
	    
	    
	    searchBar.add(new JLabel("ר����"));
		searchBar.add(this.txtSearchId);
		searchBar.add(add_button);
		//����ťע���¼�������
		add_button.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String i = txtSearchId.getText();
						System.out.println("i:"+i);
//						String j = db.searchCD(i).getTitle();
						String j;
						
						if (db.searchCD(i) != null) {
							j = db.searchCD(i).getTitle();
						} else {
							// ��δ���ҵ���¼���˴�Ӧ�����쳣������õ������Ի�������ʾ�û�
							System.out.println("δ���ҵ�����" + "db.searchCD(i) == null");
							return;
						}
						if(i.equals(j)){
								CD t = db.searchCD(i);	
								// Ӧ���Ƕ� add1_text�����ı������������¶��� string����
								System.out.println(t.getArtist());
								add1_text.setText("" + t.getArtist());
								add2_text.setText(t.getTitle());	
								add3_text.setText("" + t.getNumberOfTracks());
								add4_text.setText("" + t.getPlayingTime());
								System.out.println("���ʱ�䣺" + t.getPlayingTime());
								
								
								
								add6_text.setText("" + t.getComment());
								JOptionPane.showMessageDialog(null,"��ѯ�ɹ�","��ѯ���",JOptionPane.PLAIN_MESSAGE);
//						       
						}else{
							JOptionPane.showMessageDialog(null,"��ѯʧ��","��ѯ���",JOptionPane.PLAIN_MESSAGE);
							frame.setVisible(false);
						}
						
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
        frame.pack();//��������Ĵ�С
        
        // �Ѵ��������Ļ�����벢��ʾ
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
	}
		
		
		


}
