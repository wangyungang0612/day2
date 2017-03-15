package com.example.day2;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class ActivityTest2Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_test2);
		int value1 = ActivityTest2Activity.this.getIntent().getExtras().getInt("key_int");
	//	String value2 = ActivityTest2Activity.this.getIntent().getExtras().getString("key_string");
		String value2 = ActivityTest2Activity.this.getIntent().getStringExtra("key_string");
		Toast.makeText(ActivityTest2Activity.this, value1 + "\t" + value2, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_test2, menu);
		return true;
	}

}
