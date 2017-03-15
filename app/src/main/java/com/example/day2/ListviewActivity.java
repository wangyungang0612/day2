package com.example.day2;

import java.util.ArrayList;

import java.util.Random;

import com.example.info.Person;
import com.example.adapter.MyListAdapter;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

//1、获取数据
//2、生成Adapter
//3、使用Adapter形成列表

public class ListviewActivity extends Activity {
	private ArrayList<Person> persons;
	private MyListAdapter myListAdapter;
	private ListView listView;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		listView = (ListView) ListviewActivity.this
				.findViewById(R.id.myfristlistview);
		// 1、获取数据
		persons = createDate();
		// 2、获取适配器
		myListAdapter = new MyListAdapter(ListviewActivity.this, persons);
		// 3、使用适配器
		listView.setAdapter(myListAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(ListviewActivity.this, arg2 + "",
						Toast.LENGTH_SHORT).show();
			}
		});

	}

	// 1、获取数据

	private ArrayList<Person> createDate() {
		ArrayList<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 30; i++) {
			Person person = new Person(i + "", new Random().nextInt(99999) + "");
			persons.add(person);
		}
		return persons;

	}
}
