package com.java8.lambda;

public class Salaried extends Employee {
	private static double DEFAULT_SALARY = 12000;
	
	private double salary = DEFAULT_SALARY;

	public Salaried(String name) {
		this(name, DEFAULT_SALARY);
	}

	public Salaried(String name, double salary) {
		super(name);
		this.salary = salary;
	}

	public double getSalary() {
		return this.salary;
	}
	
	@Override
	public String toString() {
		return String.format("Salaried{name=%s, salary=%s}", getName(), getSalary());
	}
}
