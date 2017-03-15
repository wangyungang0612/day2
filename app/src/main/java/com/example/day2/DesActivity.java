package com.example.day2;

import android.os.Bundle;
import android.app.Activity;
import android.app.NotificationManager;
import android.view.Menu;

public class DesActivity extends Activity {
	public NotificationManager notificationManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_des);
		
		
		notificationManager=(NotificationManager)this.getSystemService(NOTIFICATION_SERVICE);
		notificationManager.cancel(0);
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.des, menu);
		return true;
	}

}
