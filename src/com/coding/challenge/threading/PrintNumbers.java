package com.coding.challenge.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Print 1 to 100 using 5 threads serially Output should be as follows Thread 1
 * : 1 Thread 2 : 2 Thread 3 : 3 Thread 4 : 4 Thread 5 : 5 Thread 6 : 6 Thread 7
 * : 7 Thread 8 : 8 .. and so on
 * 
 * @author bbolke
 *
 */
public class PrintNumbers {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// solution1();
		solution2();
	}

	private static void solution2() {
		MyRunnable runnable = new MyRunnable();

		Thread t1 = new Thread(runnable, "Thread-1");
		Thread t2 = new Thread(runnable, "Thread-2");
		Thread t3 = new Thread(runnable, "Thread-3");
		Thread t4 = new Thread(runnable, "Thread-4");
		Thread t5 = new Thread(runnable, "Thread-5");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

	private static void solution1() throws InterruptedException, ExecutionException {
		Mycallble callble = new Mycallble();

		ExecutorService service = Executors.newFixedThreadPool(5);
		int value = 0;
		while (value < 99) {
			Future<Integer> result = service.submit(callble);
			if (result.get() != -1) {
				value = result.get();
			}
		}

		service.shutdown();
	}
}

class Mycallble implements Callable<Integer> {
	int counter = 1;
	int threadCounter = 1;

	@Override
	public Integer call() throws Exception {
		String threadName = Thread.currentThread().getName();
		int threadNumber = Integer.parseInt(threadName.substring(threadName.length() - 1));

		if (threadNumber == threadCounter) {
			System.out.printf("%s : %d\n", threadName, counter);
			if (threadCounter == 5) {
				threadCounter = 1;
			} else {
				threadCounter++;
			}
			return counter++;
		}

		return -1;
	}

}

class MyRunnable implements Runnable {
	int counter = 1;
	int threadCounter = 1;
	Monitor lock = new Monitor();

	@Override
	public void run() {
		while (counter <= 100) {
			synchronized (lock) {

				String threadName = Thread.currentThread().getName();
				int threadNumber = Integer.parseInt(threadName.split("-")[1]);

				if (threadNumber == threadCounter) {
					System.out.printf("%s : %d\n", threadName, counter++);
					if (threadCounter == 5) {
						threadCounter = 1;
					} else {
						threadCounter++;
					}
					lock.notifyAll();
				} else {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}
}
