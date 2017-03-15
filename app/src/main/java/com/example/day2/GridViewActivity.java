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


//1����ȡ����
//2������Adapter
//3��ʹ��Adapter�γ��б�

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
		// 1����ȡ����
		persons = createDate();
		// 2����ȡ������
		myListAdapter = new MyListAdapter(GridViewActivity.this, persons);
		// 3��ʹ��������
		gridView.setAdapter(myListAdapter);

	}

	// 1����ȡ����

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
