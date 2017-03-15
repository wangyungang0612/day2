package com.example.day2;

import java.util.ArrayList;

import com.example.adapter.MyAdapter;
import com.example.adapter.MyListAdapter;
import com.example.info.Person;
import com.example.info.Person2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Spinner;

public class Sprinner3Activity extends Activity {
	private Spinner mySpinner;
	private MyAdapter myAdapter;
	private ArrayList<Person2> persons;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sprinner3);

		mySpinner = (Spinner) Sprinner3Activity.this
				.findViewById(R.id.sprinner3);

		persons = new ArrayList<Person2>();
		persons.add(new Person2("老贾", "上海 "));
		persons.add(new Person2("鹏鹏", "苏州 "));
		persons.add(new Person2("老朱", "北京"));
		persons.add(new Person2("小彭", "广州 "));
		
		

		myAdapter = new MyAdapter(Sprinner3Activity.this, persons);
		mySpinner.setAdapter(myAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sprinner3, menu);
		return true;
	}

}
