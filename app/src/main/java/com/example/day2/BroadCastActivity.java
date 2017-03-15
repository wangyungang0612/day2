package com.example.day2;

import com.example.receiver.ReceiverTest2;
import com.example.service.ServiceTest1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;

public class BroadCastActivity extends Activity {
	private final static String BROADCAST = "test";
	private final static String BROADCAST2 = "test2";
	private ReceiverTest2 receiverTest2 = new ReceiverTest2();
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_broad_cast);

		button = (Button) BroadCastActivity.this.findViewById(R.id.button24);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(BROADCAST);
				intent.putExtra("flag", true);
				BroadCastActivity.this.sendBroadcast(intent);

			}
		});

		button.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(BROADCAST);

				BroadCastActivity.this.sendBroadcast(intent);
				return false;
			}
		});

	}

	public void onClick(View v) {
		switch (v.getId()) {
		/*
		 * case R.id.button24: Intent intent = new Intent(BROADCAST);
		 * intent.putExtra("key1", "vaule");
		 * BroadCastActivity.this.sendBroadcast(intent);
		 * 
		 * break;
		 */
		case R.id.button25:
			Intent intent2 = new Intent(BROADCAST2);
			intent2.putExtra("key2", "vaule");
			BroadCastActivity.this.sendBroadcast(intent2);

			break;
		case R.id.button26:
			IntentFilter intentFilter = new IntentFilter(BROADCAST2);
			BroadCastActivity.this
					.registerReceiver(receiverTest2, intentFilter);

			break;
		case R.id.button27:
			BroadCastActivity.this.unregisterReceiver(receiverTest2);

			break;
		case R.id.button29:
			Intent intent3 = new Intent(BroadCastActivity.this,
					NotificationDemo.class);
			BroadCastActivity.this.startActivity(intent3);
			break;

		default:
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.broad_cast, menu);
		return true;
	}

}
