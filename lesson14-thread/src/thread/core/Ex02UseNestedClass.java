package thread.core;

import static utils.ThreadUtils.doTask;
import static utils.ThreadUtils.printCurrentThreadName;

import java.util.concurrent.TimeUnit;

public class Ex02UseNestedClass {

	public static void main(String[] args) {
		System.out.println("main start");
		
		Thread t1 = new Thread(new Task(), "thread1");
		t1.start();
		
		printCurrentThreadName();
		System.out.println("main end");
	}
	
	// More recommended than use anonymous class
	private static class Task implements Runnable {
		@Override
		public void run() {
			doTask(2, TimeUnit.SECONDS);
			printCurrentThreadName();
			System.out.println("running a task ...");
		}
	}
}
