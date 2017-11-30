import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

public class InputPerson extends Panel implements ActionListener
{
    TextField inputPeopleName;
    PersonSelected personSelected[];
    Button button;
	public InputPerson(PersonSelected personSelected[]) 
	{
		this.personSelected = personSelected;
		add(new Label("�����ѡ�ˣ��ö��Ÿ���"));
		inputPeopleName = new TextField(16);
		add(inputPeopleName);
		button = new Button("ȷ��");
		add(button);
		button.addActionListener(this);
		setBackground(new Color(125,253,25));
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String tempStr = inputPeopleName.getText();
		if(tempStr.length() > 0)
		{
			StringTokenizer token = new StringTokenizer(tempStr, ",��");
			personSelected = new PersonSelected[token.countTokens()];
			int  k = 0;
			while(token.hasMoreTokens())
			{
				String temp = token.nextToken();
				personSelected[k] = new PersonSelected(temp, 0);
				personSelected[k].setName(temp);
				k ++;
			}
		}
		else 
		{
			inputPeopleName.setText("���������֣��ö��Ÿ���");
		}
	}

	public PersonSelected[] getPersonSelected()
	{
		return personSelected;
	}
}
