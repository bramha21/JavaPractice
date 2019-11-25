package com.java8.thread.practice.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private int id;
	private BlockingQueue<Message> queue;
	
	public Consumer(int id, BlockingQueue<Message> queue) {
		this.id = id;
		this.queue = queue;
	}

	@Override
	public void run() {
		Message msg;
		
		try {
			while ((msg = queue.take()).getId() != -1) {
				System.out.printf("Consumer %d consumed %d%n", id, msg.getId());
				Thread.sleep((long)Math.random() * 100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
