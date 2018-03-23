package chapter22;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.regex.*;

public class ShowAddListeners extends JFrame{
	private JTextField name = new JTextField(25);
	private JTextArea results = new JTextArea(40, 65);
	private static Pattern addListener = Pattern.compile("(add\\w+?Listener\\(.*?\\))");
	private static Pattern qualifier = Pattern.compile("\\w+\\.");
	class NameL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String nm = name.getText().trim();    // 此处直接使用外部内的成员变量，这是内部类的一个优势
			if(nm.length() == 0) {
				results.setText("No match!");
				return;
			}
			Class<?> kind;
			try {
				kind = Class.forName("javax.swing." + nm);
			} catch (ClassNotFoundException ex) {
				results.setText("No match");
				return;
			}
			
			Method[] methods = kind.getMethods();
			results.setText("");
			for(Method m: methods) {
				Matcher matcher = addListener.matcher(m.toString());
				if(matcher.find()) {
					results.append(qualifier.matcher(matcher.group(1)).replaceAll("") + "\n");
				}
			}
		}
	}
	public ShowAddListeners() {
		// TODO Auto-generated constructor stub
		NameL nameListener = new NameL();
		name.addActionListener(nameListener);
		name.setEditable(true);
		JPanel top = new JPanel();
		top.add(new JLabel("Swing class name(press Enter):"));
		top.add(name);
		add(BorderLayout.NORTH, top);
		results.setEditable(false);
		add(new JScrollPane(results));
		// Initial data and test:
		name.setText("JTextArea");
		nameListener.actionPerformed(new ActionEvent("", 0, ""));
	}
	
	public static void main(String[] args) {
		SwingConsole.run(new ShowAddListeners(), 500, 500);
	}
}
