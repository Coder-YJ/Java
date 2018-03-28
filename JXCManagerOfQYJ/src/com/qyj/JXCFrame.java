package com.qyj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyVetoException;
import java.lang.reflect.Constructor;
import java.util.*;
import java.util.prefs.Preferences;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class JXCFrame {
	private JDesktopPane desktopPane;		// 创建一个复合式窗体容器
	private JFrame frame;					// 创建一个窗体
	private JLabel backLabel;				// 创建一个标签
	private Preferences preference;
	
	// 创建窗体的Map类型集合对象
	private Map<String, JInternalFrame> ifs = new HashMap<String, JInternalFrame>();		// 内部窗体集合
	
	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());			// 设置程序使用本地系统外观
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JXCFrame() {
		// TODO Auto-generated constructor stub
		frame = new JFrame("企业进销存管理系统");
		frame.addComponentListener(new FrameListener());		// 添加组件监听器
		frame.getContentPane().setLayout(new BorderLayout());   // 
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backLabel = new JLabel();
		backLabel.setVerticalAlignment(SwingConstants.TOP);
		backLabel.setHorizontalAlignment(SwingConstants.CENTER);
		updateBackImage();
		desktopPane = new JDesktopPane();
		desktopPane.add(backLabel, Integer.MIN_VALUE);
//		frame.getContentPane().add(desktopPane);			// 为什么不能直接通过frame.add?
		frame.add(desktopPane);			                    // 直接通过frame添加也行
		JTabbedPane navigationPanel = createNavigationPanel();  // 创建导航面板
//		frame.getContentPane().add(navigationPanel, BorderLayout.NORTH);
		frame.add(navigationPanel, BorderLayout.NORTH);
		frame.setVisible(true);
		
	}
	
	// 根据窗口的当前尺寸调整图片大小，更新背景图像
	private void updateBackImage() {
		if(backLabel != null) {
			int backw = JXCFrame.this.frame.getWidth();
			int backh = frame.getHeight();
			backLabel.setSize(backw, backh);
			backLabel.setText( "<html><body><image width ='" + backw   // 标签内可嵌入Html字符串
					+ "' height='"+(backh-110)+ "' src="
					+JXCFrame.this.getClass().getResource("welcome.jpg") 
					+ "'></img></body></html>"
					);
		}
	}
	
	
	// 窗体监听器
	private final class FrameListener extends ComponentAdapter {
		public void componentResized(final ComponentEvent e) {		// 窗体大小发生改变时会自动调用此函数
			updateBackImage();
		}
	}
	private JTabbedPane createNavigationPanel() { 		// 创建导航标签面板的方法
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFocusable(false);
		tabbedPane.setBackground(new Color(211, 230, 192));
		tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED));    // BevelBorder 切斜边界
		
		JPanel baseManagerPanel = new JPanel();
		baseManagerPanel.setBackground(new Color(215, 223, 194));
		baseManagerPanel.setLayout(new BoxLayout(baseManagerPanel, BoxLayout.X_AXIS));
		baseManagerPanel.add(createFrameButton("客户信息管理", "KeHuGuanli"));
		baseManagerPanel.add(createFrameButton("商品信息管理", "KeHuGuanli"));
		baseManagerPanel.add(createFrameButton("供应商信息管理", "KeHuGuanli"));
		
		JPanel depotManagerPanel = new JPanel();
		depotManagerPanel.setBackground(new Color(215, 234, 194)); 
		depotManagerPanel.setLayout(new BoxLayout(depotManagerPanel, BoxLayout.X_AXIS));
		depotManagerPanel.add(createFrameButton("库存盘点", "KuCunPanDian"));
		depotManagerPanel.add(createFrameButton("价格调整", "JiaGeTiaoZheng"));
		
		JPanel sellManagerPanel = new JPanel();
		sellManagerPanel.setBackground(new Color(215, 223, 194));
		sellManagerPanel.setLayout(new BoxLayout(sellManagerPanel, BoxLayout.X_AXIS));
		sellManagerPanel.add(createFrameButton("销售单", "XiaoShouDan"));
		sellManagerPanel.add(createFrameButton("销售退货", "XiaoShouTuiHuo"));
		
		JPanel searchStatisticPanel = new JPanel();
		searchStatisticPanel.setBounds(0, 0, 600, 41);
		searchStatisticPanel.setName("searchStatisticPanel");
		searchStatisticPanel.setBackground(new Color(215, 223, 194));
		searchStatisticPanel.setLayout(new BoxLayout(searchStatisticPanel, BoxLayout.X_AXIS));
		searchStatisticPanel.add(createFrameButton("客户信息查询", "KeHuChaXun"));
		searchStatisticPanel.add(createFrameButton("商品信息查询", "ShangPinChaXun"));
		searchStatisticPanel.add(createFrameButton("供应商信息查询", "GongYingShangChaXun"));
		searchStatisticPanel.add(createFrameButton("销售信息查询", "XiaoShouChaXun"));
		searchStatisticPanel.add(createFrameButton("销售退货查询", "XiaoShouTuiHuoChaXun"));
		searchStatisticPanel.add(createFrameButton("入库查询", "RuKuChaXun"));
		searchStatisticPanel.add(createFrameButton("入库退货查询", "RuKuTuiHuoChaXun"));
		searchStatisticPanel.add(createFrameButton("销售排行", "XiaoShouPaiHang"));
		
		JPanel stockManagerPanel = new JPanel();
		stockManagerPanel.setBounds(0, 0, 600, 41);
		stockManagerPanel.setBackground(new Color(215, 223, 194));
		stockManagerPanel.setLayout(new BoxLayout(stockManagerPanel, BoxLayout.X_AXIS));
		stockManagerPanel.add(createFrameButton("进货单", "JinHuoDan"));
		stockManagerPanel.add(createFrameButton("进货退货", "JinHuoTuiHuo"));
		
		JPanel sysManagerPanel = new JPanel();
		sysManagerPanel.setBounds(0, 0, 600, 41);
		sysManagerPanel.setBackground(new Color(215, 223, 194));
		sysManagerPanel.setLayout(new BoxLayout(sysManagerPanel, BoxLayout.X_AXIS));
		sysManagerPanel.add(createFrameButton("操作员管理", "CzyGL"));
		sysManagerPanel.add(createFrameButton("更改密码", "GengGaiMiMa"));
		sysManagerPanel.add(createFrameButton("权限管理", "QuanXianGuanLi"));
		
		
		// 将所有面板添加到导航面板中
		tabbedPane.addTab(" 基础信息管理    ", null, baseManagerPanel, "基础信息管理");
		tabbedPane.addTab(" 进货管理    ", null, stockManagerPanel, "进货管理");
		tabbedPane.addTab(" 销售管理    ", null, sellManagerPanel, "销售管理");
		tabbedPane.addTab(" 查询统计    ", null, searchStatisticPanel, "查询统计");
		tabbedPane.addTab(" 库存管理    ", null, depotManagerPanel, "库存管理");
		tabbedPane.addTab(" 系统管理    ", null, sysManagerPanel, "系统管理");

		return tabbedPane;
	}
	
	private Component createFrameButton(String fName, String cname) {
		// TODO Auto-generated method stub
		String imgUrl = "res/ActionIcon/" + fName + ".png";
		String imgUrl_roll = "res/ActionIcon/" + fName + "_roll.png";
		String imgUrl_down = "res/ActionIcon/" + fName + "_down.png";
		Icon icon = new ImageIcon(imgUrl);
		Icon icon_roll = null;
		if(imgUrl_roll != null) {
			icon_roll = new ImageIcon(imgUrl_roll);
		}
		Icon icon_down = null;
		if(imgUrl_down != null) {
			icon_down = new ImageIcon(imgUrl_down);
		}
		
		Action action = new openFrameAction(fName, cname, icon);
		JButton button = new JButton(action);
		button.setMargin(new Insets(0, 0, 0, 0));		// 设置按钮四周边界的大小
		button.setHideActionText(true);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		if(icon_roll != null) {
			button.setRolloverIcon(icon_roll);
		}
		if(icon_down != null) {
			button.setPressedIcon(icon_down);
		}
		
		return button;
	}

	
	// 主窗体菜单项的单击事件监听器
	protected final class openFrameAction extends AbstractAction {
		private String frameName = null;
		private openFrameAction() {
		}
		public openFrameAction(String cname, String frameName, Icon icon) {
			this.frameName = frameName;
			putValue(Action.NAME, cname);					// 设置Action名称
			putValue(Action.SHORT_DESCRIPTION, cname);		// 设置提示文本
			putValue(Action.SMALL_ICON, icon);				// 设置Action 图标
		}
		public void actionPerformed(final ActionEvent e) {
			JInternalFrame jf = getIFrame(frameName);
			// 在内部窗体闭关时，从内部窗体容器ifs对象中清除该窗体。
			jf.addInternalFrameListener(new InternalFrameAdapter() {
				public void internalFrameClosed(InternalFrameEvent e) {
					ifs.remove(frameName);
				}
			});
			if (jf.getDesktopPane() == null) {
				desktopPane.add(jf);
				jf.setVisible(true);
			}
			try {
				jf.setSelected(true);
			} catch (PropertyVetoException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private JInternalFrame getIFrame(String frameName) {
		JInternalFrame jf = null;
		if(!ifs.containsKey(frameName)) {
			try {
				Class<?> fClass = Class.forName("internalFrame." + frameName);
				
				Constructor<?> constructor = fClass.getConstructor(null);   // 此处用法不太明白
				jf = (JInternalFrame)constructor.newInstance(null);
				ifs.put(frameName, jf);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			jf = ifs.get(frameName);
		}
		return jf;
	}
	
	public static void  main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
//				new Login();
				new JXCFrame();
			}
		});
	}
	
	

}
