package com.example.day2.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class GetImage {
	static ImageView imageview;
	
	private static Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			Bitmap bitmap = (Bitmap) msg.obj;
		     //ʹ��ImageView��ʾ��ͼƬ
			imageview.setImageBitmap(bitmap);
		};
		
	};

	public static void getImage(ImageView imageView,final String urlsString ){
		imageview = imageView;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			
				try {
					URL url = new URL(urlsString);
				    //��URL��Ӧ����Դ��������
					InputStream inputStream = url.openStream();
				   //��InputStream�н�����ͼƬ
					Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
					
					Message message = new Message();
					message.obj = bitmap;
					handler.sendMessage(message);
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}).start();
	}

}
