package thread.pool;

import static utils.ThreadUtils.*;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Ex03ThreadPoolWithFutureTask {
	
	private static Random rd = new Random();

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Start");
		// Thread Pool
		// + Blocking Queue
		// + Threads
		
		// Thread Pool
		// + >> execute(Runnable): void
		// + >> submit(Callable<T>): Future<T>
		
		// FutureTask<V> implements RunnableFuture<V>
		// RunnableFuture<V> extends Runnable, Future<V>
		// + Callable<T> >> task
		// + Future<T>   >> return value
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		FutureTask<Integer> futureTask = new FutureTask<>(new Task());
		
		service.submit(futureTask);
		
		System.out.println(" -> " + futureTask.get());
		service.shutdown();
	}
	
	private static class Task implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			int rand = 10 + rd.nextInt(11);	// random [10,20]
			doTask(2, TimeUnit.SECONDS);
			startThread(rand);
			return rand;
		}
	}
}
