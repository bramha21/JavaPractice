package com.java8.generics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TupleDemo {
	public static void main(String[] args) {
		Tuple<Integer, String> t1 =  new Tuple<>(1, "bramha");
		System.out.println(t1.toString());

		Tuple<LocalDate, List<String>> t2 = new Tuple<LocalDate, List<String>>(LocalDate.now(), Arrays.asList("a", "b"));
		System.out.println(t2.toString());
	}
}
