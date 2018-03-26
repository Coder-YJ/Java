package chapter21;
import java.util.concurrent.*;
import java.util.*;

public class LiftOff implements Runnable{

	protected int countDown = 10;  // Default
	private static int taskCount = 0;
	private final int id = taskCount++;
	
	public LiftOff() {}
	public LiftOff(int countDown) {
		// TODO Auto-generated constructor stub
		this.countDown = countDown;
	}
	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ")," ;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
//		exec.ex
		Thread th = new Thread(new LiftOff());
		th.start();
		System.out.println("Waiting for LiftOff!");
		
		ArrayList<Future<String>> re = new ArrayList<Future<String>>();
	}
}
