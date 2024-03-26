package deadlock;

public class SuspendResumeDeadlockSolve {
	
	private static Object data = new Object();

	public static void main(String[] args) throws InterruptedException {

		final Thread thread1 = new Thread("Thread-1") {
			@SuppressWarnings("removal")
			public void run() {
				System.out.println(Thread.currentThread().getName() + " has started.");
				synchronized (data) {
					System.out.println(Thread.currentThread().getName() + " has obtained lock on data & suspended.");
					
					Thread.currentThread().suspend();
					// instead of using suspend()-resume() will warning
					// -> wait()-notify
					
					System.out.println(Thread.currentThread().getName() + " has released lock on data");
				}
				System.out.println(Thread.currentThread().getName() + " has ENDED.");
			}

		};
		thread1.start();

		Thread.sleep(2000);

		Thread thread2 = new Thread("Thread-2") {
			@SuppressWarnings("removal")	// suppress warning resume() method
			public void run() {
				System.out.println(Thread.currentThread().getName() + " has started.");

				// Thread-1 is not going to release lock on data
				// until resume() method is not called.
				// resume the thread.
				thread1.resume();
				System.out.println(thread1.getName() + " has been resumed...");

				System.out.println(Thread.currentThread().getName() + " is trying to obtain lock on data");
				synchronized (data) {
					System.out.println(Thread.currentThread().getName() + " has obtained lock on data");
					System.out.println(Thread.currentThread().getName() + " has released lock on data");
				}
				System.out.println(Thread.currentThread().getName() + " has ENDED.");
			}

		};
		thread2.start();
	}
	
	/*
	 * To avoid deadlock: after use synchronized, must ensure that no thread is locking data
	 * If there is a thread locking data -> that thread.resume()
	 * -> idea: create Class
	 *                   + data
	 *                   + thread(name thread is locking data) != null ? locked : unlock
	 *                   + isLock
	 */
}