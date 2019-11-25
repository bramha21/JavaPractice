package com.java8.lambda;

import java.util.Arrays;
import java.util.List;

public class HRDemo {
	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(new Employee("Abhi"), new Employee("Satish"), new Employee("Kiran"));
		
		List<Salaried> salarieds = Arrays.asList(new Salaried("Bali"), new Salaried("Naral"), new Salaried("Butter"));
		
		System.out.println(emps);
		System.out.println(salarieds);
		
		HR hr = new HR();
		//hr.printEmpNames(emps);
		//hr.printEmpNames(salarieds);
		
		//hr.printAllEmpNames(salarieds);
		
		hr.printFilteredEmp(emps, e -> e.getName().startsWith("B"));
	}
}
