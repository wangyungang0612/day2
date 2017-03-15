package com.example.day2;

import com.example.adapter.MyListAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;

import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ActivityTest1Activity extends Activity {
	public Button button1, button2;
	public static final String TAG = "ActivityTest1Activity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_test1);

		/*
		 * button1 = (Button) ActivityTest1Activity.this
		 * .findViewById(R.id.button10); button2 = (Button)
		 * ActivityTest1Activity.this .findViewById(R.id.button11);
		 */
		/*
		 * button1.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View arg0) { // TODO Auto-generated
		 * method stub Intent intent = new
		 * Intent(ActivityTest1Activity.this,MainActivity2.class);
		 * ActivityTest1Activity.this.startActivity(intent);
		 * 
		 * } });
		 */

		Log.d(TAG, "onCreate");

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d(TAG, "onStart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(TAG, "onResume");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d(TAG, "onPause");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d(TAG, "onStop");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d(TAG, "onDestroy");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d(TAG, "onRestart");
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button10:
			Intent intent = new Intent(ActivityTest1Activity.this,
					MainActivity2.class);
			ActivityTest1Activity.this.startActivity(intent);
			break;

		case R.id.button11:
			Intent intent2 = new Intent(ActivityTest1Activity.this,
					ActivityTest2Activity.class);
			// 使用bundle

			Bundle bundle = new Bundle();
			bundle.putInt("key_int", 2);
			bundle.putString("key_string", "hello");
			intent2.putExtras(bundle);

			// 不使用bundle
			/*
			 * intent2.putExtra("key_string", "hello2");
			 * intent2.putExtra("key_int", 3);
			 */
			ActivityTest1Activity.this.startActivity(intent2);
			break;

		case R.id.button12:
			Intent intent3 = new Intent(ActivityTest1Activity.this,
					ActivityTest3Activity.class);
			ActivityTest1Activity.this.startActivityForResult(intent3, 1);
			break;

		case R.id.button13:
			Intent intent4 = new Intent();
			intent4.setClass(ActivityTest1Activity.this,
					ActivityBActivity.class);
			ActivityTest1Activity.this.startActivity(intent4);
			break;
		case R.id.button14:
			Intent intent5 = new Intent();
			intent5.setClass(ActivityTest1Activity.this,
					ActivityCActivity.class);
			ActivityTest1Activity.this.startActivity(intent5);
			break;
		default:
			break;

		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1 && resultCode == 2) {
			Toast.makeText(ActivityTest1Activity.this,
					data.getIntExtra("key", 9999) + "", Toast.LENGTH_SHORT)
					.show();
		}
	}
}
