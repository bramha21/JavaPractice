package com.java8.lambda;

public interface Repairable {
	default void fix() {
		System.out.printf("Fixing %s%n", this.getClass().getName());
	}
}
