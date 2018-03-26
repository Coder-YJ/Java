public	class Lefthand extends Thread
{
	Lefthand()
	{
		;
	}
	public void run()
	{
		for(int i=1; i<=9; i++)
		{
			System.out.println("我是左手线程");
	}
}
}