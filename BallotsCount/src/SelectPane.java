import java.awt.*;
import java.awt.event.*;

public class SelectPane extends Panel implements ActionListener,ItemListener
{

	Label label = new Label("请将你推选的人选中");
	int maxSelectedNumber;
	int giveUpBallotCount;
	int totalVote;
	PersonSelected personSelected[];
	Button button;
	
	public SelectPane(PersonSelected personSelected[], int max)
	{
		this.personSelected = personSelected;
		maxSelectedNumber = max;
		button = new Button("确认");
		button.addActionListener(this);
		init();
		setBackground(new Color(20, 198 ,210));
	}

	public void init() 
	{
		removeAll();
		add(label);
		for(int k=0; k<personSelected.length; k++)
		{
			personSelected[k].getBox().addItemListener(this);
			add(personSelected[k].getBox());
		}
		add(button);
		validate();
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		Checkbox box = (Checkbox)e.getItemSelectable();
		
		int number = 0;
		for(int k=0; k<personSelected.length; k++)
		{
			if(personSelected[k].getBox().getState())
			{
				number ++;
			}
		}
		if(number > maxSelectedNumber)
		{
			box.setState(false);
		}
	}

	public PersonSelected[] getPersonSelected()
	{
		return personSelected;
	}
	
	public void setPersonSelected(PersonSelected personSelected[])
	{
		this.personSelected = personSelected;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		totalVote = totalVote + 1;
		int number = 0;
		for(int k=0; k<personSelected.length; k++)
		{
			if(personSelected[k].getBox().getState())
			{
				number ++;
			}
		}
		if(number == 0)
		{
			giveUpBallotCount ++;
		}
		else
		{
			for(int k=0; k<personSelected.length; k++)
			{
				if(personSelected[k].getBox().getState())
				{
					personSelected[k].addCount();
					personSelected[k].getBox().setState(false);
				}
			}
		}
		
		label.setText("已统计了：" + totalVote + "张选票，其中弃权票：" + giveUpBallotCount);
		validate();
	}

}
