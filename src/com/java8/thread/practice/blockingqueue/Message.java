package com.java8.thread.practice.blockingqueue;

public final class Message {
	private final int id;
	
	public Message(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
}
