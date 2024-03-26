package thread.pool;

import static utils.ThreadUtils.doTask;
import static utils.ThreadUtils.endThread;
import static utils.ThreadUtils.startThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;;

/**
 * Thread Pool
 * + pool size: number of threads
 * + blocking queue: number of tasks
 */
public class Ex01DemoThreadPool {
	
	private static long start = 0;
	private static int capacity = 20;
	private static Random rd = new Random();

	public static void main(String[] args) {
		System.out.println("thread main start");
		start = System.currentTimeMillis();
		
		// blocking queue
		List<Task> tasks = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			long time = 1 + rd.nextInt(4);	// time = [1, 2, 3, 4, 5]
			tasks.add(new Task(time, TimeUnit.SECONDS));
		}
		
		// thread pool - idea processors(maximum: logical processors = 2*core in CPU)
		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println("Processors: " + processors);
		ExecutorService service = Executors.newFixedThreadPool(processors);
		for (Task task: tasks) {
			service.execute(task);
		}
		
		// shutdown thread pool
		service.shutdown();
		System.out.println("thread main end");
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
			startThread(time);
			doTask(time, timeUnit);
			endThread(start);
		}
	}
}
