package thread.pool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Ex05Suppose {
	
	private static ExecutorService service;
	
	static {
		service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<List<Integer>> digitTask = new FutureTask<>(() -> loadDigits());
		FutureTask<List<String>> textTask = new FutureTask<>(() -> loadTexts());
		
		// submit tasks
		submitTasks(Arrays.asList(digitTask, textTask));
		
		// get value		
		System.out.println(digitTask.get());
		System.out.println(textTask.get());
		
		service.shutdown();
	}
	
	private static void submitTasks(List<FutureTask<?>> tasks) {
		tasks.forEach(task -> service.submit(task));
	}
	
	// suppose: loadDigits query form database -> handle -> return
	private static List<Integer> loadDigits() {
		return Arrays.asList(1, 2, 3, 6, 8);
	}
	
	private static List<String> loadTexts() {
		return Arrays.asList("a", "a", "a", "a", "a");
	}
}
