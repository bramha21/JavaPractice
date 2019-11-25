package com.java8.thread.practice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestThread {
	public static void main(String[] args) {
		// useMyThread();
		// useMyRunnable();
		// useExecutors();
		//useMyCallable();
		practiceThread1();
	}

	private static void practiceThread1() {
//		Runnable runnable = () -> {
//			try {
//			String name = Thread.currentThread().getName();
//			System.out.println("Foo " + name);
//			
//				TimeUnit.SECONDS.sleep(1);
//			
//			System.out.println("Bar " + name);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		};
		
//		Thread thread = new Thread(runnable);
//		thread.start();
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		/*
		 * executor.submit(()-> { String threadName = Thread.currentThread().getName();
		 * System.out.println("Hello " + threadName); });
		 */
		//executor.shutdownNow();
		
		Callable<String> task = () -> {
			TimeUnit.SECONDS.sleep(5);
			return "Bramha";
		};
		
//		Future<String> future = executor.submit(task);
//		//executor.shutdownNow();
//		
//		try {
//			System.out.println(future.isDone());
//			System.out.println(future.get(3,TimeUnit.SECONDS));
//			System.out.println(future.isDone());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (TimeoutException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		executor = Executors.newWorkStealingPool();
		
		List<Callable<String>> callbles = Arrays.asList(
				()  -> "Task1",
				()  -> "Task2",
				()  -> "Task3");
		
		try {
			executor.invokeAll(callbles).parallelStream().map(future -> {
				try {
					return future.get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}).forEach(System.out::println);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void useMyCallable() {
		List<Callable<String>> callables = Stream.iterate(1, n -> n + 1).limit(10).map(MyCallable::new)
				.collect(Collectors.toList());

		ExecutorService service = Executors.newFixedThreadPool(3);

		try {
			List<Future<String>> futures = service.invokeAll(callables);
			for (Future<String> future : futures) {
				System.out.println(future.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		service.shutdown();
	}

	private static void useExecutors() {
		List<MyRunnable> runnables = Stream.iterate(1, n -> n + 1).map(MyRunnable::new).limit(10)
				.collect(Collectors.toList());

		ExecutorService service = Executors.newFixedThreadPool(5);
		runnables.forEach(service::execute);

		service.shutdown();
	}

	private static void useMyRunnable() {
		List<MyRunnable> runnables = Stream.iterate(1, n -> n + 1).map(MyRunnable::new).limit(10)
				.collect(Collectors.toList());

		runnables.forEach(MyRunnable::start);
	}

	private static void useMyThread() {
		List<MyThread> threads = Stream.iterate(-1, n -> n + 1).map(MyThread::new).limit(10)
				.collect(Collectors.toList());

		threads.forEach(MyThread::start);
	}
}
