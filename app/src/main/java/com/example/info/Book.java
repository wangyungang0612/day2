package com.example.info;
//1、创建目标类；
public class Book {
	private String name;
	private String price;
	private String id;
	private String author;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book [name=" + name + ", price=" + price + ", id=" + id
				+ ", author=" + author + "]";
	}

}
