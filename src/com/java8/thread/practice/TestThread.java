package com.java8.thread.practice;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestThread {
	public static void main(String[] args) {
		// useMyThread();
		// useMyRunnable();
		// useExecutors();
		useMyCallable();
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
