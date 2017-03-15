package com.example.day2.util;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.example.info.Book;

//1����дMySaxHelper �̳� DefaultHandler
public class MySaxHelper extends DefaultHandler {
	// 1������Ŀ����
	private Book book;
	// 2������ArrayList��������Ž��������
	private ArrayList<Book> books;
	private String content;

	// ��ӹ��췽��
	public MySaxHelper(ArrayList<Book> books) {
		super();
		this.books = books;
	}

	@Override
	// 3����дstartDocument���� ��SAX������������XML�ĵ���ʼʱ������õķ���
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		System.out.println("startDocument");
	}

	@Override
	//4����дendDocument����	��SAX������������XML�ĵ�����ʱ������õķ���
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
	//5����дendElement������SAX������������ĳ��Ԫ�ؽ���ʱ������õķ��� ����localName��¼����Ԫ��������
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
	//6����дcharacters����	��SAX������������ĳ��Ԫ�ؿ�ʼʱ������õķ��� ����localName��¼����Ԫ��������
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		content = new String(ch, start, length);
	}

}
