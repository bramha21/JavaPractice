package com.java8.functional.interfaces;

public class Book {

	String name;
	Integer price;
	String tag;
	String author;
	@Override
	public String toString() {
		return "Article [name=" + name + ", price=" + price + ", tag=" + tag + ", author=" + author + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book(String name, int price, String tag, String author) {
		super();
		this.name = name;
		this.price = price;
		this.tag = tag;
		this.author = author;
	}
}
