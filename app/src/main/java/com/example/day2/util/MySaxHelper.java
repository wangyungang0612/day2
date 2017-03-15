package com.example.day2.util;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.example.info.Book;

//1、编写MySaxHelper 继承 DefaultHandler
public class MySaxHelper extends DefaultHandler {
	// 1）创建目标类
	private Book book;
	// 2）创建ArrayList，用来存放解析结果；
	private ArrayList<Book> books;
	private String content;

	// 添加构造方法
	public MySaxHelper(ArrayList<Book> books) {
		super();
		this.books = books;
	}

	@Override
	// 3）复写startDocument（） 当SAX解析器解析到XML文档开始时，会调用的方法
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("startDocument");
	}

	@Override
	//4）复写endDocument（）	当SAX解析器解析到XML文档结束时，会调用的方法
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
		System.out.println("endDocument");
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		System.out.println("startElement " + localName);
		if ("book".equals(localName)) {
			book = new Book();
			book.setAuthor(attributes.getValue("author"));

		}
	}

	@Override
	//5）复写endElement（）当SAX解析器解析到某个元素结束时，会调用的方法 其中localName记录的是元素属性名
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		System.out.println("endElement " + localName);
		if ("book".equals(localName)) {
			books.add(book);

		}
		if ("id".equals(localName)) {
			book.setId(content);

		}
		if ("price".equals(localName)) {
			book.setPrice(content);

		}
		if ("name".equals(localName)) {
			book.setName(content);

		}
	}

	@Override
	//6）复写characters（）	当SAX解析器解析到某个元素开始时，会调用的方法 其中localName记录的是元素属性名
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		content = new String(ch, start, length);
	}

}
