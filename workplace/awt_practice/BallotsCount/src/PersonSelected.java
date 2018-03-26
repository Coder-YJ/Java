import java.awt.*;

public class PersonSelected extends Panel
{
	String name;
	int count;
	Checkbox box;
	public PersonSelected(String name, int count) 
	{
		this.name = name;
		this.count = count;
		box = new Checkbox();
		add(box);
	}
	
	public void setName(String name)
	{
		this.name = name;
		box.setLabel(name);
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addCount()
	{
		count ++;
	}

	public int getCount()
	{
		return count;
	}
	
	public Checkbox getBox()
	{
		return box;
	}
}
