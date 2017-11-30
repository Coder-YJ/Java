import java.awt.*;
import java.awt.event.*;

public class SelectWindow extends Frame implements ActionListener 
{

	PersonSelected personSelected[];
	InputPerson input;
	SelectPane select;
	ResultArea show;
	Button buttonInput,buttonSelect,buttonResult,reNew;
	int max = 3;
	CardLayout card;
	Panel center = new Panel(),
		  south  = new Panel();
	
	public SelectWindow() 
	{
		personSelected = new PersonSelected[1];
		
		for(int k=0; k<personSelected.length; k++)
		{
			personSelected[k] = new PersonSelected("无名", 0);
		}
		
		card = new CardLayout();
		center.setLayout(card);
		input = new InputPerson(personSelected);
		select = new SelectPane(personSelected, max);
		show = new ResultArea(personSelected);
		
		center.add("001", new Label("选票程序", Label.CENTER));
		center.add("input", input);
		center.add("select", select);
		center.add("show", show);
		
		buttonInput = new Button("输入候选人界面");
		buttonInput.addActionListener(this);
		buttonSelect = new Button("统计选票界面，最多选" + max + "人");
		buttonSelect.addActionListener(this);
		buttonResult = new Button("查看得票界面");
		buttonResult.addActionListener(this);
		reNew = new Button("重新选举");
		reNew.addActionListener(this);
		
		south.add(buttonInput);
		south.add(buttonSelect);
		south.add(buttonResult);
		south.add(reNew);
		add(center,BorderLayout.CENTER);
		add(south,BorderLayout.SOUTH);
		setSize(450, 200);
		setVisible(true);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Button b = (Button)e.getSource();
		setTitle(b.getLabel());
		if(b == buttonInput)
		{
			card.show(center, "input");
			buttonInput.setEnabled(false);
		}
		if(b == buttonSelect)
		{
			personSelected = input.getPersonSelected();
			select.setPersonSelected(personSelected);
			select.init();
			card.show(center, "select");
		}
		if(b == buttonResult)
		{
			personSelected = select.getPersonSelected();
			show.setPersonSelected(personSelected);
			card.show(center, "show");
		}
		if(b == reNew)
		{
			personSelected = new PersonSelected[1];
			for(int k=0; k<personSelected.length; k++)
			{
				personSelected[k] = new PersonSelected("无名", 0);
			}
			
			center.removeAll();
			input = new InputPerson(personSelected);
			select = new SelectPane(personSelected, 3);
			show = new ResultArea(personSelected);
			center.add("001", new Label("选票程序", Label.CENTER));
			center.add("input", input);
			center.add("select", select);
			center.add("show", show);
			card.show(center, "001");
			buttonInput.setEnabled(true);
			center.validate();
		}
	}
}


