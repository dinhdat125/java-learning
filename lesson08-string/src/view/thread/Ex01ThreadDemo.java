package view.thread;

import java.util.concurrent.TimeUnit;

public class Ex01ThreadDemo {

	public static void main(String[] args) {
		System.out.println("Start Main");
		printCurrentThread(7);
		
		Runnable taskA = new Runnable() {
			
			@Override
			public void run() {
				doTask(3);
				printCurrentThread(13);
				doTask();
			}
		};
		Thread t1 = new Thread(taskA, "Thread 1");	// new
		t1.start();	// .start -> gọi đến runnable (gọi đến taskA) -> gọi đến hàm run
		
		doTask(5);
		printCurrentThread(20);
		System.out.println("End Main");
	}
	
	private static void doTask() {
		System.out.println("Load Data");
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
	
	private static void printCurrentThread(int line) {
		System.out.println("Current Thread(line " + line + " -> '" + Thread.currentThread().getName() + "'");
	}
}
