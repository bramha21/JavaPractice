package com.java8.lambda;

public class Employee {
	private String name;
	
	public Employee(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.format("Employee{%s}", this.name);
	}
}
