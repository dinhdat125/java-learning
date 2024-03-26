package utils;

import java.util.concurrent.TimeUnit;

public class ThreadUtils {

	private ThreadUtils() {
	}
	
	public static void printCurrentThreadName() {
		System.out.println(">> Thread: " + Thread.currentThread().getName());
	}
	
	public static void startThread() {
		System.out.println(Thread.currentThread().getName() + " is running ...");
	}
	
	public static void startThread(long value) {
		System.out.println(Thread.currentThread().getName() + " is running ... " + value);
	}
	
	public static void endThread(long start) {
		System.out.println(getThreadName() + " tooks " + (System.currentTimeMillis() - start) + "ms");
	}
	
	public static String getThreadName() {
		return Thread.currentThread().getName();
	}
	
	// virtual task with a certain time
	public static void doTask(long time, TimeUnit timeUnit) {
		try {
			timeUnit.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// block current Thread
	public static void join(Thread thread) {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
