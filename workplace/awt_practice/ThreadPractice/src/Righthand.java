public 	class Righthand extends Thread
{
	public void run()
	{
		for(int i=1; i<=9; i++)
		{
			System.out.println("我是右手线程");
		}
	}
}