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
		     //使用ImageView显示该图片
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
				    //打开URL对应的资源的输入流
					InputStream inputStream = url.openStream();
				   //从InputStream中解析出图片
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
