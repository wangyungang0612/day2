package com.example.day2.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Getget {
	public static String getget(String baseurl,List<BasicNameValuePair> list){
		String pram = URLEncodedUtils.format(list, "UTF-8");
		System.out.println(pram);
	
		//3.将baseUrl和pram进行拼接
		String url = baseurl + pram;
		System.out.println(url);		
		//4.设置GET方法
		HttpGet get = new HttpGet(url);
		
		//5.新建client
		HttpClient client = new DefaultHttpClient();		
		//发起GET请求
		try {
			HttpResponse response = client.execute(get);
			if(response.getStatusLine().getStatusCode()  == HttpStatus.SC_OK){
			String  result = EntityUtils.toString(response.getEntity(),"utf_8");
			return result;
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
