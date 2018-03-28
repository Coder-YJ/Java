package internalFrame.gysGuanLi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

import com.qyj.dao.Dao;

public class GysTianJiaPanel extends JPanel{

	JTextField quanChengF;		// 供应商全称
	JTextField jianChengF;		// 供应商简称
	JTextField bianMaF;			// 邮政编码
	JTextField diZhiF;			// 地址
	JTextField dianHuaF;        // 电话
	JTextField chuanZhengF;      // 传真
	JTextField lianXiRenF;		// 联系人
	JTextField lianXiRenDianHuaF; // 联系人电话
	JTextField yinHangF;		// 开户银行
	JTextField EmailF;			// 邮箱
	
	JButton tjButton;			 // 添加
	JButton resetButton;         // 重填
	
	class ResetActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			quanChengF.setText("");
			jianChengF.setText("");
			bianMaF.setText("");
			diZhiF.setText("");
			dianHuaF.setText("");
			chuanZhengF.setText("");
			lianXiRenF.setText("");
			lianXiRenDianHuaF.setText("");
			yinHangF.setText("");
			EmailF.setText("");
		}
	}
	
	class TjActionListener implements ActionListener {

		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(quanChengF.getText().equals("") || jianChengF.getText().equals("") || bianMaF.getText().equals("")          // 验证用户是否输入全部信息
					|| diZhiF.getText().equals("")	|| dianHuaF.getText().equals("") || chuanZhengF.getText().equals("")
					|| lianXiRenF.getText().equals("")  || lianXiRenDianHuaF.getText().equals("") || yinHangF.getText().equals("")
					|| EmailF.getText().equals("")) {
				JOptionPane.showMessageDialog(GysTianJiaPanel.this, "请填写全部信息");
				return;
			}
			
			// 验证是否存在同名供应商
			try {
				ResultSet set = Dao.query("select max(id) from tb_gysinfo");		// 获取供应商的最大ID编号
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
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
}
