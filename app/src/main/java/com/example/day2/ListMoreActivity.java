package com.example.day2;

import java.util.ArrayList;
import java.util.Random;

import com.example.adapter.ExAdapter;
import com.example.info.Group;
import com.example.info.Person;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ExpandableListView;

public class ListMoreActivity extends Activity {

	ExpandableListView expandableListView;
	ArrayList<Group> groups;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_more);

		 expandableListView = (ExpandableListView) ListMoreActivity.this
		 .findViewById(R.id.expandlstview);
		
		 groups = createData();
		 ExAdapter exAdapter = new ExAdapter(ListMoreActivity.this, groups);
		 expandableListView.setAdapter(exAdapter);

	}

	ArrayList<Group> createData() {
		ArrayList<Group> groups = new ArrayList<Group>();
		for (int i = 1000; i < 1010; i++) {
			ArrayList<Person> persons = new ArrayList<Person>();
			for (int j = 0; j < 5; j++) {
				Person person = new Person(j + "", new Random().nextInt(99999)
						+ "");
				persons.add(person);
			}
			Group group = new Group(i + "", persons);
			groups.add(group);
		}
		return groups;
	}

}
