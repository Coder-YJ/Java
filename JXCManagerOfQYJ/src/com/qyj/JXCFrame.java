package com.qyj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.*;
import java.util.prefs.Preferences;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class JXCFrame {
	private JDesktopPane deskTopPane;
	private JFrame frame;
	private JLabel backLabel;
	private Preferences preference;
	
	// 创建窗体的Map类型集合对象
	private Map<String, JInternalFrame> ifs = new HashMap<String, JInternalFrame>();
	
	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public JXCFrame() {
		// TODO Auto-generated constructor stub
		frame = new JFrame("企业进销存管理系统");
		frame.addComponentListener(new FrameListener());
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backLabel = new JLabel();
		backLabel.setVerticalAlignment(SwingConstants.TOP);
		backLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		updateBackImage();
		deskTopPane = new JDesktopPane();
		deskTopPane.add(backLabel, Integer.MIN_VALUE);
		frame.getContentPane().add(deskTopPane);
		JTabbedPane navigationPanel = createNavigationPanel();
		frame.getContentPane().add(navigationPanel, BorderLayout.NORTH);
		frame.setVisible(true);
		
	}
	
	private void updateBackImage() {
		if(backLabel != null) {
			int backw = JXCFrame.this.frame.getWidth();
			int backh = frame.getHeight();
			backLabel.setSize(backw, backh);
			backLabel.setText( "<html><body><image width ='" + backw 
					+ "' height='"+(backh-110)+ "' src="
					+JXCFrame.this.getClass().getResource("welcome.jpg") 
					+ "'></img></body></html>"
					);
		}
	}
	
	
	// 窗体监听器
	private final class FrameListener extends ComponentAdapter {
		public void componentResized(final ComponentEvent e) {
//			updateBackImage();
		}
	}
	private JTabbedPane createNavigationPanel() { // 创建导航标签面板的方法
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFocusable(false);
		tabbedPane.setBackground(new Color(211, 230, 192));
		tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		
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
//		tabbedPane.setFocusable(false);
//		tabbedPane.setBackground(new Color(211, 230, 192));
//		tabbedPane.setBorder(new BevelBorder(BevelBorder.RAISED));
//
//		JPanel baseManagePanel = new JPanel(); // 基础信息管理面板
//		baseManagePanel.setBackground(new Color(215, 223, 194));
//		baseManagePanel.setLayout(new BoxLayout(baseManagePanel,
//				BoxLayout.X_AXIS));
//		baseManagePanel.add(createFrameButton("客户信息管理", "KeHuGuanLi"));
//		baseManagePanel.add(createFrameButton("商品信息管理", "ShangPinGuanLi"));
//		baseManagePanel.add(createFrameButton("供应商信息管理", "GysGuanLi"));
//
//		JPanel depotManagePanel = new JPanel(); // 库存管理面板
//		depotManagePanel.setBackground(new Color(215, 223, 194));
//		depotManagePanel.setLayout(new BoxLayout(depotManagePanel,
//				BoxLayout.X_AXIS));
//		depotManagePanel.add(createFrameButton("库存盘点", "KuCunPanDian"));
//		depotManagePanel.add(createFrameButton("价格调整", "JiaGeTiaoZheng"));
//
//		JPanel sellManagePanel = new JPanel();// 销售管理面板
//		sellManagePanel.setBackground(new Color(215, 223, 194));
//		sellManagePanel.setLayout(new BoxLayout(sellManagePanel,
//				BoxLayout.X_AXIS));
//		sellManagePanel.add(createFrameButton("销售单", "XiaoShouDan"));
//		sellManagePanel.add(createFrameButton("销售退货", "XiaoShouTuiHuo"));
//
//		JPanel searchStatisticPanel = new JPanel();// 查询统计面板
//		searchStatisticPanel.setBounds(0, 0, 600, 41);
//		searchStatisticPanel.setName("searchStatisticPanel");
//		searchStatisticPanel.setBackground(new Color(215, 223, 194));
//		searchStatisticPanel.setLayout(new BoxLayout(searchStatisticPanel,
//				BoxLayout.X_AXIS));
//		searchStatisticPanel.add(createFrameButton("客户信息查询", "KeHuChaXun"));
//		searchStatisticPanel.add(createFrameButton("商品信息查询", "ShangPinChaXun"));
//		searchStatisticPanel.add(createFrameButton("供应商信息查询",
//				"GongYingShangChaXun"));
//		searchStatisticPanel.add(createFrameButton("销售信息查询", "XiaoShouChaXun"));
//		searchStatisticPanel.add(createFrameButton("销售退货查询",
//				"XiaoShouTuiHuoChaXun"));
//		searchStatisticPanel.add(createFrameButton("入库查询", "RuKuChaXun"));
//		searchStatisticPanel
//				.add(createFrameButton("入库退货查询", "RuKuTuiHuoChaXun"));
//		searchStatisticPanel.add(createFrameButton("销售排行", "XiaoShouPaiHang"));
//
//		JPanel stockManagePanel = new JPanel();// 进货管理面板
//		stockManagePanel.setBackground(new Color(215, 223, 194));
//		stockManagePanel.setLayout(new BoxLayout(stockManagePanel,
//				BoxLayout.X_AXIS));
//		stockManagePanel.add(createFrameButton("进货单", "JinHuoDan"));
//		stockManagePanel.add(createFrameButton("进货退货", "JinHuoTuiHuo"));
//
//		sysManagePanel = new JPanel();// 系统管理面板
//		sysManagePanel.setBackground(new Color(215, 223, 194));
//		sysManagePanel
//				.setLayout(new BoxLayout(sysManagePanel, BoxLayout.X_AXIS));
//		sysManagePanel.add(createFrameButton("操作员管理", "CzyGL"));
//		sysManagePanel.add(createFrameButton("更改密码", "GengGaiMiMa"));
//		sysManagePanel.add(createFrameButton("权限管理", "QuanManager"));
//
//		tabbedPane.addTab("   基础信息管理   ", null, baseManagePanel, "基础信息管理");
//		tabbedPane.addTab("   进货管理   ", null, stockManagePanel, "进货管理");
//		tabbedPane.addTab("   销售管理   ", null, sellManagePanel, "销售管理");
//		tabbedPane.addTab("   查询统计   ", null, searchStatisticPanel, "查询统计");
//		tabbedPane.addTab("   库存管理   ", null, depotManagePanel, "库存管理");
//		tabbedPane.addTab("   系统管理   ", null, sysManagePanel, "系统管理");

		return tabbedPane;
	}
	
	private Component createFrameButton(String fName, String cname) {
		// TODO Auto-generated method stub
		String imgUrl = "res/ActionIcon/" +fName + ".png";
		String imgUrl_roll = "res/ActionIcon" + fName + "_roll.png";
		String imgUrl_down = "res/ActionIcon" + fName + "_down.png";
		Icon icon = new ImageIcon(imgUrl);
		Icon icon_roll = null;
		if(imgUrl_roll != null) {
			icon_roll = new ImageIcon(imgUrl_roll);
		}
		Icon icon_down = null;
		if(imgUrl_down != null) {
			icon_down = new ImageIcon(imgUrl_down);
		}
		
		
		return null;
	}

	public static void  main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Login();
			}
		});
	}

}
