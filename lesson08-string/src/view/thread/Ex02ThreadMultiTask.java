package view.thread;

import java.util.concurrent.TimeUnit;

public class Ex02ThreadMultiTask {

	static long start = 0;
	
	public static void main(String[] args) {
		System.out.println("Main Start==========");
		start = System.currentTimeMillis();
		
		Task taskLoadA = new Task("Load task A", 4);
		//taskLoadA.run();
		executeThread(taskLoadA, "thread-1");
		
		Task taskLoadB = new Task("Load task B", 2);
		//taskLoadB.run();
		executeThread(taskLoadB, "thread-2");
		
		Task taskLoadC = new Task("Load task C", 5);
		//taskLoadC.run();
		executeThread(taskLoadC, "thread-3");
		
		//System.out.println("Load A B C -> " + (System.currentTimeMillis() - start) + "(ms)");
		System.out.println("Main End=========");
	}
	
	private static void executeThread(Runnable runnable, String threadName) {
		Thread thread = new Thread(runnable, threadName);
		thread.start();
	}
	
	/*
	 * Giả lập task gồm
	 * + Tên task
	 * + Thời gian thực thi
	 */
	private static class Task implements Runnable {

		private String name;
		private int seconds;
		
		public Task(String name, int seconds) {
			this.name = name;
			this.seconds = seconds;
		}

		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			System.out.println("Thread " + threadName + " started executing Task " + name + "...");
			doTask(seconds);
			System.out.println("Thread " + threadName + " finished executing Task " + name + ">>>");
			System.out.println(name + " -> " + (System.currentTimeMillis() - start) + "(ms)");
		}
	}
	
	private static void doTask(int second) {
		try {
			for (int i = 0; i < second; i++) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println(Thread.currentThread().getName() + " execises " + i + "s");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
