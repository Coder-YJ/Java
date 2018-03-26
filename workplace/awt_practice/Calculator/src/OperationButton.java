import java.awt.Color;
import javax.swing.*;
public class OperationButton extends JButton{
	
	String operateSign;
	
	public OperationButton(String operateSign) {
		// TODO Auto-generated constructor stub
		super(operateSign);
		this.operateSign = operateSign;
		setForeground(new Color(250, 150, 0));
	}
	
	public String getOperateSign() {
		return operateSign;
	}
}
