import java.awt.Color;
import javax.swing.*;
public class OperationButton extends JButton{
	
	String operateSign;
	
	public OperationButton(String operateSign) {
		// TODO Auto-generated constructor stub
		super(operateSign);
		this.operateSign = operateSign;
		setForeground(Color.yellow);
	}
	
	public String getOperateSign() {
		return operateSign;
	}
}
