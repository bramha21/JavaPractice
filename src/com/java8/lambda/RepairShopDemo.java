package com.java8.lambda;

import java.util.Arrays;

public class RepairShopDemo {
	public static void main(String[] args) {
		RepairShop.fixAll(Arrays.asList(new Toaster(), new Furniture(), new Blender()));
	}
}
