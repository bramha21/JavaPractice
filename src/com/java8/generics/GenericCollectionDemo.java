package com.java8.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericCollectionDemo {
	
	private void noGenerics() {
		List nums = new ArrayList();
		nums.add(3);
		nums.add(1);
		nums.add(4);
		nums.add("oops");
	}
	
	public static void main(String[] args) {
		
	}
}
