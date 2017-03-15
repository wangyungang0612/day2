package com.example.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.info.Person;
import com.example.info.Person2;

public class MyAdapter extends BaseAdapter {

	private ArrayList<Person2> persons;

	private Context Context;

	public MyAdapter(Context Context, ArrayList<Person2> persons) {
		this.Context = Context;
		this.persons = persons;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return persons.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return persons.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub

		arg1 = LayoutInflater.from(Context).inflate(
				com.example.day2.R.layout.item3, null);

		TextView textView1 = (TextView) arg1
				.findViewById(com.example.day2.R.id.textView3);
		TextView textView2 = (TextView) arg1
				.findViewById(com.example.day2.R.id.textView4);

		textView1.setText(persons.get(arg0).getPersonName());
		textView2.setText(persons.get(arg0).getPersonAddress());

		return arg1;

	}

}
