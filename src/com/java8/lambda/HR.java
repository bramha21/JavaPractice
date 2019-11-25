package com.java8.lambda;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class HR {
	public void printEmpNames(List<Employee> employees) {
		employees.stream().
		map(Employee::getName).
		forEach(System.out::println);
	}
	
	public void printAllEmpNames(List<? extends Employee> emp) {
		emp.stream().
		map(Employee::getName).
		forEach(System.out::println);
	}
	
	public void printFilteredEmp(List<? extends Employee> emps, Predicate<? super Employee> predicate) {
		for (Employee e : emps) {
			if (predicate.test(e)) {
				System.out.println(e.getName());
			}
		}
	}
}
