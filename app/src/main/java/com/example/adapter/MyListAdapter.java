package com.example.adapter;

import java.util.ArrayList;

import com.example.day2.R;
import com.example.info.Person;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyListAdapter extends BaseAdapter {
	private ArrayList<Person> persons;
	private Context context;

	public MyListAdapter(Context context, ArrayList<Person> persons) {
		this.context = context;
		this.persons = persons;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return persons.size();
	}

	@Override
	public Object getItem(int poision) {
		// TODO Auto-generated method stub
		return persons.get(poision);
	}

	@Override
	public long getItemId(int poision) {
		// TODO Auto-generated method stub
		return poision;
	}

	@Override
	public View getView(final int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub

		arg1 = LayoutInflater.from(context).inflate(R.layout.item_listview,
				null);

		TextView textView1 = (TextView) arg1.findViewById(R.id.textView1);
		TextView textView2 = (TextView) arg1.findViewById(R.id.textView2);
		Button button = (Button) arg1.findViewById(R.id.button1);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg) {
				// TODO Auto-generated method stub
				Toast.makeText(context, "position " + arg0, Toast.LENGTH_SHORT)
						.show();
			}
		});

		textView1.setText(persons.get(arg0).getNameString());
		textView2.setText(persons.get(arg0).getNumberString());

		return arg1;
	}

}
