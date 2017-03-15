package com.example.day2;

import java.util.ArrayList;
import java.util.Random;

import com.example.adapter.MyListAdapter;
import com.example.info.Person;

import android.os.Bundle;
import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ComplexwidgetActivity extends Activity {
	public Button button1;
	public Button button2;
	public Button button3;
	public Button button4;
	public Button button5;
	public Button button6;
	public Button button7;
	private Spinner myspinner;
	private ArrayAdapter<CharSequence> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_complexwidget);

		button1 = (Button) ComplexwidgetActivity.this
				.findViewById(R.id.button3);
		button2 = (Button) ComplexwidgetActivity.this
				.findViewById(R.id.button4);
		button3 = (Button) ComplexwidgetActivity.this
				.findViewById(R.id.button5);

		button4 = (Button) ComplexwidgetActivity.this
				.findViewById(R.id.button6);
		button5 = (Button) ComplexwidgetActivity.this
				.findViewById(R.id.button7);
		button6 = (Button) ComplexwidgetActivity.this
				.findViewById(R.id.button8);
		button6 = (Button) ComplexwidgetActivity.this
				.findViewById(R.id.button9);

		button1.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ComplexwidgetActivity.this.startActivity(new Intent(
						ComplexwidgetActivity.this, ListviewActivity.class));
			}
		});

		button2.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ComplexwidgetActivity.this.startActivity(new Intent(
						ComplexwidgetActivity.this, GridViewActivity.class));
			}
		});

		button3.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ComplexwidgetActivity.this.startActivity(new Intent(
						ComplexwidgetActivity.this, ListViem2Activity.class));
			}
		});

		myspinner = (Spinner) ComplexwidgetActivity.this
				.findViewById(R.id.spinner);
		adapter = ArrayAdapter.createFromResource(ComplexwidgetActivity.this,
				R.array.spinnername, android.R.layout.simple_list_item_1);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		myspinner.setAdapter(adapter);
		myspinner.setPrompt("城市");

		myspinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				String str = arg0.getItemAtPosition(arg2).toString();
				Toast.makeText(ComplexwidgetActivity.this, "你点击的是:" + str, 2000)
						.show();

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		button5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ComplexwidgetActivity.this,
						Sprinner2Activity.class);
				ComplexwidgetActivity.this.startActivity(intent);

			}
		});

		button6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(ComplexwidgetActivity.this,
						ListMoreActivity.class);
				ComplexwidgetActivity.this.startActivity(intent);

			}
		});
	}

	private ArrayList<Person> createDate() {
		ArrayList<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 30; i++) {
			Person person = new Person(i + "", new Random().nextInt(99999) + "");
			persons.add(person);
		}
		return persons;

	}

	public void onClick(View v) {
		ArrayAdapter<CharSequence> adapter;

		switch (v.getId()) {
		case R.id.button6:
			AlertDialog.Builder builder = new Builder(
					ComplexwidgetActivity.this);
			builder.setTitle("hello")
					.setIcon(
							ComplexwidgetActivity.this.getResources()
									.getDrawable(R.drawable.ic_launcher))
					// .setMessage("Android")
					.setNegativeButton("yes",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {
									// TODO Auto-generated method stub
									Toast.makeText(ComplexwidgetActivity.this,
											"yes", Toast.LENGTH_SHORT).show();
								}
							})
					.setPositiveButton("no",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface arg0,
										int arg1) {
									// TODO Auto-generated method stub
									Toast.makeText(ComplexwidgetActivity.this,
											"no", Toast.LENGTH_SHORT).show();
								}
							})
					.setAdapter(
							new MyListAdapter(ComplexwidgetActivity.this,
									createDate()), null).show();

			break;

		case R.id.button8:
			ProgressDialog progressDialog = new ProgressDialog(
					ComplexwidgetActivity.this);
			progressDialog.setMessage("progressDialog");
			progressDialog.setIndeterminate(false);
			progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
			progressDialog.setTitle("hello");
			progressDialog.setIcon(ComplexwidgetActivity.this.getResources()
					.getDrawable(R.drawable.ic_launcher));
			progressDialog.setMax(100);
			progressDialog.show();
			progressDialog.setProgress(70);
			break;

		}
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Toast.makeText(ComplexwidgetActivity.this, "如果返回，则证明老贾是傻逼！！！",
					Toast.LENGTH_SHORT).show();
		}
		return super.onKeyDown(keyCode, event);

	}

	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Toast.makeText(ComplexwidgetActivity.this, "如果抬起，则证明老贾是傻逼！！！",
					Toast.LENGTH_SHORT).show();
		}
		return super.onKeyUp(keyCode, event);

	}
}
