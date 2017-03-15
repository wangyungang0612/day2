package com.example.day2;

import cn.jpush.android.api.JPushInterface;

import com.example.day2.HandlerTestActivity.MyTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FirstActivity extends Activity {
	public Button button;
	private static final int IMAGE1 = 9999;
	private static final int IMAGE2 = 2222;

	private Handler mhandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch (msg.what) {
			case IMAGE1:
				Intent intent = new Intent();
				intent.setClass(FirstActivity.this, LoginActivity.class);
				FirstActivity.this.startActivity(intent);
				FirstActivity.this.finish();
				break;
			case IMAGE2:
				Intent intent1 = new Intent();
				intent1.setClass(FirstActivity.this, LoginActivity.class);
				FirstActivity.this.startActivity(intent1);
				FirstActivity.this.finish();
				break;

			default:
				break;
			}

		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);

		Message message = new Message();
		;
		message.what = IMAGE1;
		mhandler.sendMessageDelayed(message, 100000);

		button = (Button) FirstActivity.this.findViewById(R.id.button1);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mhandler.removeMessages(IMAGE1);
				Message message = new Message();
				message.what = IMAGE2;
				mhandler.sendMessage(message);
				// mhandler.sendMessageDelayed(message, 0);

			}
		});

		JPushInterface.init(FirstActivity.this);

	}

	@Override
	protected void onResume() {

		super.onResume();
		JPushInterface.onResume(FirstActivity.this);
	}

	@Override
	protected void onPause() {

		super.onPause();
		JPushInterface.onPause(FirstActivity.this);
	}

}
