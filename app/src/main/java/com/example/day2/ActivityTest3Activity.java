package com.example.day2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class ActivityTest3Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_test3);

	}
	
	public void onClick(View v){
		switch(v.getId()){
		case R.id.button13:
			Intent intent = new Intent();
			intent.putExtra("key", 1);
			ActivityTest3Activity.this.setResult(2, intent);
			ActivityTest3Activity.this.finish();
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_test3, menu);
		return true;
	}

}
