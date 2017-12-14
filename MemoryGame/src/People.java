import java.io.*;

public class People implements Serializable, Comparable     // 复习 Serializable 接口, Comparable
{
	String name = null;
	int time = 0;
			
	public People(String name, int time) 
	{
		this.name = name;
		this.time = time;
	}

	public int getTime()
	{
		return time;
	}
	
	public String getName()
	{
		return name;
	}
	
	
	@Override
	public int compareTo(Object o) 
	{
		People p = (People)o;
		if((this.time - p.time) == 0)
		{
			return 1;
		}
		else 
		{
			return (this.time - p.time);			
		}

	}

}
