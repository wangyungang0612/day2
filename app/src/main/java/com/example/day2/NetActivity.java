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
		
		//��ȡ����ͼƬ ��װ��Ĵ���
		imageView = (ImageView) NetActivity.this.findViewById(R.id.ImageView);
		//       ͼƬ�������ַ
		String urlsString = "http://imgs.soufun.com/news/2014_12/24/house/1419408695022_000.jpg";
		GetImage.getImage(imageView, urlsString);
		
		//ʹ��HttpClient��������     
		//������ҳ�����Ĳ�ͬ����ȡ��ҳԴ���� ���ַ��� GET �� post �ķ�װ��Ĵ���
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
        
    //ʹ��HttpURLConnection��������     
        new  Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					//����Ŀ���ַ
					URL url = new URL("https://www.baidu.com");
					//����openConnection()������������
					HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
					//����Http����ķ�ʽ
					connection.setRequestMethod("POST");
					//�������ӳ�ʱ
					connection.setConnectTimeout(5000);
					//����getInputStream������ȡ���������ص�������
					InputStream inputStream = connection.getInputStream();
					//�����������ж�ȡ
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
		
		
//		//������ҳ�����Ĳ�ͬ����ȡ��ҳԴ���� ���ַ��� GET �� post
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//				//1.����������list��
//				list = new ArrayList<BasicNameValuePair>();
//				list.add(new BasicNameValuePair("kw", "lol"));
//				
//				//2.�Բ������б���
//				String pram = URLEncodedUtils.format(list, "UTF-8");
//				System.out.println(pram);
//				
//				//3.��url��pram����ƴ��
//				String url = "http://tieba.baidu.com/f?" + pram;
//				System.out.println(url);
//				
//				//4.����GET����
//				HttpGet get = new HttpGet(url);
//				
//				//5.�½�client
//				HttpClient client = new DefaultHttpClient();
//				
//				//����GET����
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
//				//1.����������list��
//				list2 = new ArrayList<BasicNameValuePair>();
//				list2.add(new BasicNameValuePair("kw", "lol"));
//				
//				
//				try {
//					//2.�Ѳ�������PostEntity��
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
