package internalFrame.gysGuanLi;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.qyj.dao.Dao;

import internalFrame.gysGuanLi.GysTianJiaPanel.ResetActionListener;
import internalFrame.gysGuanLi.GysTianJiaPanel.TjActionListener;
import keyListener.InputKeyListener;
import model.TbGysinfo;

public class GysTianJiaPanel extends JPanel{

	JTextField quanChengF;		// 供应商全称
	JTextField jianChengF;		// 供应商简称
	JTextField bianMaF;			// 邮政编码
	JTextField diZhiF;			// 地址
	JTextField dianHuaF;        // 电话
	JTextField chuanZhenF;      // 传真
	JTextField lianXiRenF;		// 联系人
	JTextField lianXiRenDianHuaF; // 联系人电话
	JTextField yinHangF;		// 开户银行
	JTextField EMailF;			// 邮箱
	
	JButton tjButton;			 // 添加按钮
	JButton resetButton;         // 重填按钮
	
	
	public GysTianJiaPanel() {
		setLayout(new GridBagLayout());		// GridBagLayout 布局需了解
		setBounds(10, 10, 510, 302);

		setupComponet(new JLabel("供应商全称："), 0, 0, 1, 1, false);

		quanChengF = new JTextField();
		setupComponet(quanChengF, 1, 0, 3, 400, true);

		setupComponet(new JLabel("简称："), 0, 1, 1, 1, false);

		jianChengF = new JTextField();
		setupComponet(jianChengF, 1, 1, 1, 160, true);

		setupComponet(new JLabel("邮政编码："), 2, 1, 1, 1, false);
		bianMaF = new JTextField();
		bianMaF.addKeyListener(new InputKeyListener());
		setupComponet(bianMaF, 3, 1, 1, 0, true);

		setupComponet(new JLabel("地址："), 0, 2, 1, 1, false);
		diZhiF = new JTextField();
		setupComponet(diZhiF, 1, 2, 3, 0, true);

		setupComponet(new JLabel("电话："), 0, 3, 1, 1, false);
		dianHuaF = new JTextField();
		dianHuaF.addKeyListener(new InputKeyListener());
		setupComponet(dianHuaF, 1, 3, 1, 0, true);

		setupComponet(new JLabel("传真："), 2, 3, 1, 1, false);
		chuanZhenF = new JTextField();
		chuanZhenF.addKeyListener(new InputKeyListener());
		setupComponet(chuanZhenF, 3, 3, 1, 0, true);

		setupComponet(new JLabel("联系人："), 0, 4, 1, 1, false);
		lianXiRenF = new JTextField();
		setupComponet(lianXiRenF, 1, 4, 1, 0, true);

		setupComponet(new JLabel("联系人电话："), 2, 4, 1, 1, false);
		lianXiRenDianHuaF = new JTextField();
		lianXiRenDianHuaF.addKeyListener(new InputKeyListener());
		setupComponet(lianXiRenDianHuaF, 3, 4, 1, 0, true);

		setupComponet(new JLabel("开户银行："), 0, 5, 1, 1, false);
		yinHangF = new JTextField();
		setupComponet(yinHangF, 1, 5, 1, 0, true);

		setupComponet(new JLabel("电子信箱："), 2, 5, 1, 1, false);
		EMailF = new JTextField();
		setupComponet(EMailF, 3, 5, 1, 0, true);

		final JButton tjButton = new JButton();
		tjButton.addActionListener(new TjActionListener());
		tjButton.setText("添加");
		setupComponet(tjButton, 2, 6, 1, 0, false);

		resetButton = new JButton();
		setupComponet(resetButton, 3, 6, 1, 0, false);
		resetButton.addActionListener(new ResetActionListener());
		resetButton.setText("重填");
	}
	// 设置组件位置并添加到容器中
	private void setupComponet(JComponent component, int gridx, int gridy,
			int gridwidth, int ipadx, boolean fill) {
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		gridBagConstrains.insets = new Insets(5, 1, 3, 1);
		if (gridwidth > 1)
			gridBagConstrains.gridwidth = gridwidth;
		if (ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		if (fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		add(component, gridBagConstrains);
	}
	
	
	class ResetActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			quanChengF.setText("");
			jianChengF.setText("");
			bianMaF.setText("");
			diZhiF.setText("");
			dianHuaF.setText("");
			chuanZhenF.setText("");
			lianXiRenF.setText("");
			lianXiRenDianHuaF.setText("");
			yinHangF.setText("");
			EMailF.setText("");
		}
	}
	
	class TjActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(quanChengF.getText().equals("") || jianChengF.getText().equals("") || bianMaF.getText().equals("")          // 验证用户是否输入全部信息
					|| diZhiF.getText().equals("")	|| dianHuaF.getText().equals("") || chuanZhenF.getText().equals("")
					|| lianXiRenF.getText().equals("")  || lianXiRenDianHuaF.getText().equals("") || yinHangF.getText().equals("")
					|| EMailF.getText().equals("")) {
				JOptionPane.showMessageDialog(GysTianJiaPanel.this, "请填写全部信息");
				return;
			}
			
			// 验证是否存在同名供应商
			try {
				ResultSet haveUser = Dao.query("select max(id) from tb_gysinfo where name='" + quanChengF.getText().trim());		// 获取供应商的最大ID编号
				if(haveUser.next()) {
					JOptionPane.showMessageDialog(GysTianJiaPanel.this, "存在同名供应商，添加信息失败", "供应商添加信息", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				ResultSet set = Dao.query("select max(id) from tb_gysinfo"); 		// 获取当前最大的供应商ID编号
				String id = null;
				if(set != null && set.next()) {					// 创建新的供应商编号
					String sid = set.getString(1).trim();
					if(sid == null) {
						id = "gys1001";
					} else {
						String str = sid.substring(3);
						id = "gys" + (Integer.parseInt(str) + 1);
					}
				}
				
				TbGysinfo gysInfo = new TbGysinfo();		// 创建供应商实体对象
				gysInfo.setId(id);
				gysInfo.setAddress(diZhiF.getText().trim());
				gysInfo.setBianma(bianMaF.getText().trim());
				gysInfo.setFax(chuanZhenF.getText().trim());
				gysInfo.setYh(yinHangF.getText().trim());
				gysInfo.setJc(jianChengF.getText().trim());
				gysInfo.setName(quanChengF.getText().trim());
				gysInfo.setLian(lianXiRenF.getText().trim());
				gysInfo.setLtel(lianXiRenDianHuaF.getText().trim());
				gysInfo.setMail(EMailF.getText().trim());
				gysInfo.setTel(dianHuaF.getText().trim());	
				
				Dao.addGys(gysInfo);  // 调用addGys()方法存储供应商
				JOptionPane.showMessageDialog(GysTianJiaPanel.this, "已成功添加客户", "客户添加信息", JOptionPane.INFORMATION_MESSAGE);
				resetButton.doClick();	// 触发“重填”按钮的单击动作	
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
