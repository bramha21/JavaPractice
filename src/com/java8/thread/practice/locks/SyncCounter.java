package com.java8.thread.practice.locks;

public class SyncCounter {

	private int count;

	public synchronized void increment() {
		count++;
	}

	public synchronized int getCount() {
		return count;
	}

}
