package thread.core;

import java.util.concurrent.TimeUnit;

import static utils.ThreadUtils.*;

public class Ex04CheckTookTime {
	
	private static long start = 0;

	public static void main(String[] args) {
		start = System.currentTimeMillis();
		
		Task task1 = new Task(3, TimeUnit.SECONDS);
		Task task2 = new Task(5, TimeUnit.SECONDS);
		Task task3 = new Task(3, TimeUnit.SECONDS);
		
		executeThread(task1, "thread1");
		executeThread(task2, "thread2");
		executeThread(task3, "thread3");
	}
	
	private static class Task implements Runnable {
		private long time;
		private TimeUnit timeUnit;
		
		public Task(long time, TimeUnit timeUnit) {
			this.time = time;
			this.timeUnit = timeUnit;
		}
		
		@Override
		public void run() {
			startThread();
			doTask(time, timeUnit);
			demoSync();
			endThread(start);
		}
		
		// synchronized data
		// synchronized method
		private static synchronized void demoSync() {
			System.out.println(getThreadName() + " accessed synchronized method");
			System.out.println("end synchronized method");
		}
	}
	
	private static void executeThread(Runnable runnable, String threadName) {
		Thread thread = new Thread(runnable, threadName);
		thread.start();
	}
}
