package com.example.day2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class ActivityCActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_c);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button16:
			Intent intent = new Intent();
			intent.setClass(ActivityCActivity.this, ActivityBActivity.class);
			ActivityCActivity.this.startActivity(intent);
			break;
		case R.id.button17:
			Intent intent2 = new Intent();
	 		intent2.setClass(ActivityCActivity.this, ActivityCActivity.class);
			ActivityCActivity.this.startActivity(intent2);
			break;
		default:
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_c, menu);
		return true;
	}

}
