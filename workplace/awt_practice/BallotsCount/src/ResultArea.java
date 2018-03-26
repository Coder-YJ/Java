import java.awt.*;

public class ResultArea extends Panel
{
	PersonSelected personSelected[];
	TextArea text;
	
	public ResultArea(PersonSelected personSelected[]) 
	{
		this.personSelected = personSelected;
		text  = new TextArea(12, 40);
		text.setText(null);
		text.setBackground(new Color(200, 251, 23));
		add(text);
		setBackground(new Color(85, 153 ,65));
	}
	
	public void setPersonSelected(PersonSelected personSelected[])
	{
		text.setText(null);
		String[] str = new String[personSelected.length];
		int count[] = new int[personSelected.length];
		for(int k=0; k<str.length; k++)
		{
			str[k] = personSelected[k].getName();
			count[k] = personSelected[k].getCount();
		}
		
		for(int k=0; k<str.length; k++)
		{
			for(int i=k+1 ; i<str.length; i++)
			{
				if(count[i] > count[k])
				{
					String temp = str[k];
					int n = count[k];
					str[k] = str[i];
					count[k] = count[i];
					str[i] = temp;
					count[i] = n;
				}
			}
		}
		
		for(int k=0; k<str.length; k++)
		{
			text.append("\n" + str[k] + "ตรฦฑ" + count[k]);
		}
		
		validate();
	}

}
