package com.example.day2;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.PrivateCredentialPermission;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.example.day2.R.id;
import com.example.day2.util.MySaxHelper;
import com.example.info.Book;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class ParseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parse);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dom:

			try {
				// 2������ArrayList��������Ž��������
				ArrayList<Book> books = new ArrayList<Book>();
				// 3��ͨ��DocumentBuilderFactory.newInstance() ��ȡfactory��
				DocumentBuilderFactory factory = DocumentBuilderFactory
						.newInstance();
				// 4��ͨ��factoty���documentBuilderʵ����
				DocumentBuilder documentBuilder = factory.newDocumentBuilder();
				// 5��ȡ��Dom documentBuilder.parse(InputStream)��
				Document document = documentBuilder.parse(ParseActivity.this
						.getResources().getAssets().open("book.xml"));
				// 6��Ѱ�Ҹ��ڵ� document.getDocumentElement();
				Element root = document.getDocumentElement();
				// 7��ͨ�����ڵ��ȡ���е�item�� root.getElementByTagName();
				NodeList nodeList = root.getElementsByTagName("book");

				// 8���������е�item��
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
					Element element = (Element) node;
					Book book = new Book();
					// 9�����Ի��attribute��
					book.setAuthor(element.getAttribute("author"));
					// 10����ʱ���Ի�ȡÿ��item�µ��ӽڵ㣻
					NodeList nodeList2 = element.getChildNodes();

					// 11������ÿ���ӽڵ㣻
					for (int j = 0; j < nodeList2.getLength(); j++) {
						Node node2 = nodeList2.item(j);
						// 12���ж�����
						if (node2.getNodeType() == Node.ELEMENT_NODE) {
							Element bookelement = (Element) node2;
							// 13������bookelement.getNodeName() ����Ӧ��ֵ
							// bookelement.getFirstChild().getNodeValue()
							// ����Ŀ����Ķ�����
							if ("id".equals(bookelement.getNodeName())) {
								book.setId(bookelement.getFirstChild()
										.getNodeValue());
							}

							if ("name".equals(bookelement.getNodeName())) {
								book.setName(bookelement.getFirstChild()
										.getNodeValue());

							}

							if ("price".equals(bookelement.getNodeName())) {
								book.setPrice(bookelement.getFirstChild()
										.getNodeValue());
							}

						}

					}
					// 14����Ӷ�����Arraylist�У�
					books.add(book);
				}
				for (Book book : books) {
					System.out.println(book.toString());
					Toast.makeText(ParseActivity.this, book.toString(),
							Toast.LENGTH_SHORT).show();
				}
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		// 2����дsax����
		case R.id.sax:
			try {
				// 1������ArrayList��������Ž��������
				ArrayList<Book> arrayList = new ArrayList<Book>();
				// 2����xml�ļ�ת��ΪInputSource��ʽ��
				InputSource inputSource = new InputSource(ParseActivity.this
						.getResources().getAssets().open("book.xml"));
				// 3��ͨ��SAXParserFactory.newInstance() ��ȡfactory��
				SAXParserFactory factory = SAXParserFactory.newInstance();
				// 4��ͨ��factory���saxParser��
				SAXParser saxParser = factory.newSAXParser();
				// 5��ͨ��saxParser.getXMLReader() ���xml�Ķ�����
				XMLReader xmlReader = saxParser.getXMLReader();
				// 6������ �Ķ��� handler xmlReader.setContentHandler��
				xmlReader.setContentHandler(new MySaxHelper(arrayList));
				// 7������ �Ķ�����InputSource xmlReader.parse(in2)
				xmlReader.parse(inputSource);
				for (Book book : arrayList) {
					System.out.println(book.toString());
					Toast.makeText(ParseActivity.this, book.toString(),
							Toast.LENGTH_SHORT).show();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.json1:

			try {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("name", "pig");
				jsonObject.put("age", 20);
				System.out.println(jsonObject);

				JSONObject jsonObject2 = new JSONObject();
				jsonObject2.put("name", "dog");
				jsonObject2.put("age", 21);
				System.out.println(jsonObject2);

				JSONArray jsonArray = new JSONArray();
				jsonArray.put(jsonObject);
				jsonArray.put(jsonObject2);
				System.out.println(jsonArray);

				JSONObject jsonObject3 = new JSONObject();
				jsonObject3.put("array", jsonArray);
				jsonObject3.put("key", "value");
				System.out.println(jsonObject3);

				String value1 = jsonObject3.getString("key");
				String value2 = jsonObject3.optString("key");
				String value3 = jsonObject3.optString("key", "default");

				System.out.println(value1);
				System.out.println(value2);
				System.out.println(value3);

				JSONArray jsonArray2 = jsonObject3.optJSONArray("array");
				for (int i = 0; i < jsonArray2.length(); i++) {
					JSONObject jsonObject4 = jsonArray2.optJSONObject(i);
					System.out.println(jsonObject4);

				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		case R.id.json2:
			Intent intent = new Intent(ParseActivity.this, JsonActivity.class);
			ParseActivity.this.startActivity(intent);

			break;

		default:
			break;
		}
	}
}
