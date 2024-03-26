package deadlock;

public class SuspendResumeDeadlock {
	
	private static Object data = new Object();
	
	public static void main(String[] args) throws InterruptedException {

		final Thread thread1 = new Thread("Thread-1") {
			@SuppressWarnings("removal")	// suppress warning from suspend() method
			public void run() {
				System.out.println(Thread.currentThread().getName() + " has started.");
				// synchronized data
				synchronized (data) {
					System.out.println(Thread.currentThread().getName() + " has obtained lock on data & suspended.");
					/*
					 * suspend the thread, now this thread will release lock on data (by
					 * exiting synchronized block) only when resume() method is called on this
					 * thread, thread will go in waiting state.
					 */
					Thread.currentThread().suspend();

					System.out.println(Thread.currentThread().getName() + " has released lock on data");
				}
				System.out.println(Thread.currentThread().getName() + " has ENDED.");
			}

		};
		thread1.start();

		Thread.sleep(2000); // This delay ensures Thread-2 after Thread-1

		Thread thread2 = new Thread("Thread-2") {
			public void run() {
				System.out.println(Thread.currentThread().getName() + " has started.");

				/*
				 * for acquiring lock on data thread-1 must have released lock on data,
				 * if lock is not released, Thread-2 will keep on waiting for Thread-1
				 * to release lock on data & deadlock will be formed.
				 */
				
				System.out.println(Thread.currentThread().getName() + " is trying to obtain lock on data");

				// Thread-1 is not going to release lock on data
				// until resume() method is not called.
				// Thread.currentThread().resume();
				synchronized (data) {
					System.out.println(Thread.currentThread().getName() + " has obtained lock on data");
					System.out.println(Thread.currentThread().getName() + " has released lock on data");
				}
				System.out.println(Thread.currentThread().getName() + " has ENDED.");
			}

		};
		thread2.start();
	}
	
}