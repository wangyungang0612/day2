package com.example.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.message.BasicNameValuePair;
import com.example.day2.util.GetImage;
import com.example.day2.util.GetPost;
import com.example.day2.util.Getget;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;

public class NetActivity extends Activity {
	ImageView imageView;
	List<BasicNameValuePair> list;
	List<BasicNameValuePair> list2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_net);
		
		//获取网络图片 封装后的代码
		imageView = (ImageView) NetActivity.this.findViewById(R.id.ImageView);
		//       图片的网络地址
		String urlsString = "http://imgs.soufun.com/news/2014_12/24/house/1419408695022_000.jpg";
		GetImage.getImage(imageView, urlsString);
		
		//使用HttpClient访问网络     
		//根据网页最后面的不同，获取网页源代码 两种方法 GET 和 post 的封装后的代码
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				list2 = new ArrayList<BasicNameValuePair>();
				list2.add(new BasicNameValuePair("kw", "lol"));
				
				 String result = GetPost.getPost("http://tieba.baidu.com/f", list2);
				 if (result != null) {
					 System.out.println(result);				
				}		   								
			}
			
		});//.start();
		
		
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				list = new ArrayList<BasicNameValuePair>();
				list.add(new BasicNameValuePair("kw", "lol"));
				
				 String result = Getget.getget("http://tieba.baidu.com/f?", list);
				 if (result != null) {
					 System.out.println(result);				
				}		   								
			}
			
		});//.start();
        
    //使用HttpURLConnection访问网络     
        new  Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					//传入目标地址
					URL url = new URL("https://www.baidu.com");
					//调用openConnection()方法进行连接
					HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
					//设置Http请求的方式
					connection.setRequestMethod("POST");
					//设置连接超时
					connection.setConnectTimeout(5000);
					//调用getInputStream方法获取服务器返回的输入流
					InputStream inputStream = connection.getInputStream();
					//对输入流进行读取
					BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
					StringBuilder stringBuilder = new StringBuilder();
					String line;
					while((line = reader.readLine()) != null){
						stringBuilder.append(line);
					}
					System.out.println(stringBuilder.toString());
					connection.disconnect();
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
		
		
//		//根据网页最后面的不同，获取网页源代码 两种方法 GET 和 post
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//				//1.将参数放入list中
//				list = new ArrayList<BasicNameValuePair>();
//				list.add(new BasicNameValuePair("kw", "lol"));
//				
//				//2.对参数进行编码
//				String pram = URLEncodedUtils.format(list, "UTF-8");
//				System.out.println(pram);
//				
//				//3.将url和pram进行拼接
//				String url = "http://tieba.baidu.com/f?" + pram;
//				System.out.println(url);
//				
//				//4.设置GET方法
//				HttpGet get = new HttpGet(url);
//				
//				//5.新建client
//				HttpClient client = new DefaultHttpClient();
//				
//				//发起GET请求
//				try {
//					HttpResponse response = client.execute(get);
//					if(response.getStatusLine().getStatusCode()  == HttpStatus.SC_OK){
//						String  result = EntityUtils.toString(response.getEntity(),"utf_8");
//						System.out.println(result);
//					}
//				} catch (ClientProtocolException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				
//			}
//		});//	.start()
//		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//				//1.将参数放入list中
//				list2 = new ArrayList<BasicNameValuePair>();
//				list2.add(new BasicNameValuePair("kw", "lol"));
//				
//				
//				try {
//					//2.把参数放入PostEntity中
//					HttpPost post = new HttpPost("http://tieba.baidu.com/f");
//					post.setEntity(new UrlEncodedFormEntity(list2,"utf-8"));
//					
//					HttpClient client = new DefaultHttpClient();
//					
//					HttpResponse response = client.execute(post);
//					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//						String result = EntityUtils.toString(response.getEntity(),"utf-8");
//						System.out.println(result);
//						
//					}
//				} catch (UnsupportedEncodingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (ClientProtocolException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				
//			}
//		}).start();
//
//				
	}


}
