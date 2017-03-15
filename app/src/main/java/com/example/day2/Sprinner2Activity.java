package com.example.day2;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Sprinner2Activity extends Activity {
	public Button button1;

	private Spinner spinner;
	private ArrayAdapter<String> adapter;
	private ArrayList<String> list;
//	private List<String> list = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sprinner2);

		spinner = (Spinner) Sprinner2Activity.this.findViewById(R.id.sprinner2);
		button1 = (Button) Sprinner2Activity.this.findViewById(R.id.sprinner3);

	    list = new ArrayList<String>();
		list.add("北京");
		list.add("天津");
		list.add("上海");
		list.add("苏州");

		ArrayAdapter adapter = new ArrayAdapter<String>(Sprinner2Activity.this,
				R.layout.item, R.id.textviewid, list);

		// adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setPrompt("城市");

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Sprinner2Activity.this,
						Sprinner3Activity.class);
				Sprinner2Activity.this.startActivity(intent);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sprinner2, menu);
		return true;
	}

}
