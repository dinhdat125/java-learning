package thread.core;

import static utils.ThreadUtils.*;

import java.util.concurrent.TimeUnit;

public class Ex01DemoThread {

	public static void main(String[] args) {
		System.out.println("main start");
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				doTask(2, TimeUnit.SECONDS);
				printCurrentThreadName();
				System.out.println("running a task ...");
			}
		}, "thread1");
		t1.start();	// t1.start() >>> t1.run()[native method] >> t1.run() >> runnable.run()
		// t1.run(); -> khi gọi trực tiếp t1.run() mà k thông qua t1.start() thì chương trình sẽ 
		// thực thi tuần tự từ trên xuống theo 1 thread duy nhất là thread main
		
		printCurrentThreadName();
		System.out.println("main end");
	}
}
