package com.java8.thread.practice.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LocksDemo {
	private Counter counter = new Counter();
	private SyncCounter syncCounter = new SyncCounter();
	private LockedCounter lockedCounter = new LockedCounter();
	private AtomicCounter atomicCounter = new AtomicCounter();
	
	public static void main(String[] args) {
		LocksDemo demo = new LocksDemo();
		demo.demoCounter();
		demo.demoSyncCounter();
		demo.demoLockedCounter();
		demo.demoAtomicCounter();
	}

	private void demoCounter() {
		ExecutorService service = Executors.newCachedThreadPool();
		IntStream.range(0, 1000)
		.forEach(i -> service.submit(counter::increment));
		service.shutdown();
		System.out.println("Counter Count=" + counter.getCount());
	}
	
	private void demoSyncCounter() {
		ExecutorService service = Executors.newCachedThreadPool();
		IntStream.range(0, 1000)
		.forEach(i -> service.submit(syncCounter::increment));
		service.shutdown();
		System.out.println("SyncCounter Count=" + syncCounter.getCount());
	}
	
	private void demoLockedCounter() {
		ExecutorService service = Executors.newCachedThreadPool();
		IntStream.range(0, 1000)
		.forEach(i -> service.submit(lockedCounter::increment));
		service.shutdown();
		System.out.println("LockedCounter Count=" + lockedCounter.getCount());
	}
	
	private void demoAtomicCounter() {
		ExecutorService service = Executors.newCachedThreadPool();
		IntStream.range(0, 1000)
		.forEach(i -> service.submit(atomicCounter::increment));
		service.shutdown();
		System.out.println("AtomicCounter Count=" + atomicCounter.getCount());
	}
}
