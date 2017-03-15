package com.example.day2;

import java.util.ArrayList;

import java.util.Random;

import com.example.adapter.MyListAdapter;
import com.example.info.Person;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.GridView;
import android.widget.ListView;


//1、获取数据
//2、生成Adapter
//3、使用Adapter形成列表

public class GridViewActivity extends Activity {
	private ArrayList<Person> persons;
	private MyListAdapter myListAdapter;
	private GridView gridView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grid_view);
		gridView = (GridView) GridViewActivity.this
				.findViewById(R.id.myfristgridview);
		// 1、获取数据
		persons = createDate();
		// 2、获取适配器
		myListAdapter = new MyListAdapter(GridViewActivity.this, persons);
		// 3、使用适配器
		gridView.setAdapter(myListAdapter);

	}

	// 1、获取数据

	private ArrayList<Person> createDate() {
		
		gridView.setNumColumns(3);
		ArrayList<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 30; i++) {
			Person person = new Person(i + "", new Random().nextInt(99999) + "");
			persons.add(person);
		}
		return persons;

	}
}
