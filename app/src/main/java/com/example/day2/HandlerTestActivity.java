package com.example.day2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.R.integer;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class HandlerTestActivity extends Activity {
	public Button button;
	public ImageView imageView;
	private static final int IMAGE = 9999;
	ProgressBar progressBar;
	
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			//用来处理接收的message
			super.handleMessage(msg);
			switch (msg.what) {
			case IMAGE:
				imageView.setRotation((imageView.getRotation() + 0.2f) % 360);
			//	Toast.makeText(HandlerTestActivity.this, msg.obj + "", Toast.LENGTH_SHORT).show();
				Message message = new Message();
				message.what = IMAGE;
				mHandler.sendMessageDelayed(message, 10);
				break;

			default:
				break;
			}
			
		}
	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler_test);
		
		imageView = (ImageView) HandlerTestActivity.this.findViewById(R.id.imageView1);
		button = (Button) HandlerTestActivity.this.findViewById(R.id.button1);
		progressBar = (ProgressBar) HandlerTestActivity.this.findViewById(R.id.progressBar2);	
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mHandler.removeMessages(IMAGE);
				Message message = new Message();
				message.what = IMAGE;
			//	message.obj = "我点了一下";
				mHandler.sendMessageDelayed(message, 1000);
				MyTask myTask = new MyTask();//必须在UI主线程中new
				myTask.execute(20);//必须在UI主线程中调用，只能执行一次
				
				
			}
		});
	}
	
	class MyTask extends AsyncTask{
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			progressBar.setVisibility(View.VISIBLE);
			progressBar.setProgress(0);
			progressBar.setMax(100);
		}

		@Override
		protected Object doInBackground(Object... arg0) {
			// TODO Auto-generated method stub	
			int progress = 0;
			while(progress < 100){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				progress++;
				publishProgress(progress);
			}
			return null;
		}
		
		@Override
		protected void onProgressUpdate(Object... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			progressBar.setProgress((Integer) values[0]);
		}
		
		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			progressBar.setVisibility(View.INVISIBLE);
			
		}

		
		
	}

	
}
