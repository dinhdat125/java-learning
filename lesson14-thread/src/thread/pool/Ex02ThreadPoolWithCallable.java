package thread.pool;

import static utils.ThreadUtils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;;

public class Ex02ThreadPoolWithCallable {
	
	private static int capacity = 20;
	private static Random rd = new Random();

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("thread main start");
		
		// blocking queue
		List<Task> tasks = new ArrayList<>(capacity);
		for (int i = 0; i < capacity; i++) {
			tasks.add(new Task());
		}
		
		// thread pool
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		for (Task task: tasks) {
			Future<Integer> future = service.submit(task);
			System.out.println("random: " + future.get());
		}
		
		service.shutdown();
		System.out.println("thread main end");
	}
	
	private static class Task implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			int rand = 10 + rd.nextInt(11);	// random [10,20]
			doTask(1, TimeUnit.SECONDS);
			startThread(rand);
			return rand;
		}
	}
}
