import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

public class DatabaseClient extends Applet implements Runnable, ActionListener{

	String formname;    // 数据库中的表名	
	TextField inputText;
	Choice choice;
	Checkbox  totalLike, foreLike, backLike, midContains;
	CheckboxGroup group = null;
	Button buttonSearch;
	TextArea displayResult;
	Label hintBar;
	Socket socket = null;
	DataInputStream in = null;
	DataOutputStream out = null;
	Thread thread;
	boolean ok = false;
	int N = 0;            // 字段个数
	String[] fieldName;   // 字段名字存放数组
	String[] fieldExplain; // 字段解释的存放数组
	
	public void init() {
		thread = new Thread(this);
		inputText = new TextField(19);
		buttonSearch = new Button("查询");
		choice = new Choice();
		formname = getParameter("0");   // 从index.html得到“0” 的值
		String number = getParameter("ziduanAmount");
		N = Integer.parseInt(number);
		fieldName = new String[N];
		fieldExplain = new String[N];
		
		for (int i = 1, k = 0; i<= N; i++, k++) {
			String str = getParameter("" + i);   // 从 index.html得到字段名称及解释
			fieldName[k] = str.substring(0, str.indexOf(":")).trim();
			fieldExplain[k] = str.substring(str.indexOf(":") + 1).trim();
		}
		
		
	}
	
	public DatabaseClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
