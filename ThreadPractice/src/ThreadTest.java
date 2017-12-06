public class ThreadTest 
{
	public static void main(String args[])
	{

		Lefthand left = new Lefthand();
		Righthand right = new Righthand();

		left.start();
		right.start();
		
		for(int i=1; i<=9; i++)
		{
			System.out.println("我是主线程");
		}
		try 
		{
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
